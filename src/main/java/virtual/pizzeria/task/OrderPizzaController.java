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
import virtual.pizzeria.task.dto.Order;
import virtual.pizzeria.task.dto.Pizza;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class OrderPizzaController {
    // внедренный интерфейс
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
    public OrderPizzaController(
            PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        // заполняем данными из БД
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepo.findAll().forEach(pizzas::add);
        return "design";
    }

    @PostMapping
    public String processOrder(
                               @ModelAttribute Order order, Errors errors) {
        // если есть ошибки, возвращаемся на первоначальную форму
        if (errors.hasErrors()) {
            return "design";
        }
//        Pizza saved = pizzaRepo.save(pizza);
//        order.addPizza(saved);

        log.info("редиректим на страницу с текущим заказом");
        return "redirect:/orders/current";
    }
}
