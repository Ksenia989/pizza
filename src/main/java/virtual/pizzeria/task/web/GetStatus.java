package virtual.pizzeria.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Получение статуса заказа
 */
@Controller
@RequestMapping("/getstatus")
public class GetStatus {
    @PostMapping
    public void makeOrder() {

    }
}
