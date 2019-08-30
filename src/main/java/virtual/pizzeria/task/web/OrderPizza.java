package virtual.pizzeria.task.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Обработчик заказа пичек
 */
@Slf4j
@Controller
public class OrderPizza {
    @GetMapping("/")
    public String orderPizza() {
        // возвращает домашнюю страницу
        return "home";
    }
}
