package virtual.pizzeria.task.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Обработчик заказа
 */
@Slf4j
@Controller
//@RequestMapping("/")
public class OrderPizza {
    @GetMapping("/")
    public String orderPizza() {
        return "home";
    }
}
