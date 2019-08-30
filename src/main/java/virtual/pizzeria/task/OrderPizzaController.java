package virtual.pizzeria.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.db.PizzaRepository;
import virtual.pizzeria.task.dto.Order;
import virtual.pizzeria.task.dto.Pizza;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class OrderPizzaController {
    // внедренный интерфейс
    private OrderRepository orderRepo;
    private PizzaRepository pizzaRepo;

    @ModelAttribute(name = "design")
    public Order design() {
        Order order = new Order();
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepo.findAll().forEach(pizzas::add);
        order.setPizzas(pizzas);
        return order;
    }

    @Autowired
    public OrderPizzaController(PizzaRepository pizzaRepo,
                                OrderRepository orderRepo) {
        this.pizzaRepo = pizzaRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "design";
    }

    /**
     * Метод при возвращении объекта заказа
     */
    @PostMapping
    public String processOrder(@ModelAttribute Order order, Errors errors) {
        // если есть ошибки в order, возвращаемся на первоначальную форму
        if (errors.hasErrors()) {
            log.warn("Есть ошибки на форме. Редирект обратно на нее");
            return "design";
        }
        // сохраняем объект заказа в БД
        order.setPaymentSum(calculateOrderSum(order.getPizzas()));
        orderRepo.save(order);
        log.info("запись о заказе успешно сохранена");
        log.info("редиректим на страницу с текущим заказом");
        return "success";
    }

    private double calculateOrderSum(List<Pizza> pizzas) {
        double sum = 0.0;
        for (Pizza pizza : pizzas) {
            if (pizza.isActive()) {
                sum += pizza.getPrice();
            }
        }
        return sum;
    }
}
