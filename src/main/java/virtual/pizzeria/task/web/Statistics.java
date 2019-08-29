package virtual.pizzeria.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Получение статистики по определенной дате
 */
@Controller
@RequestMapping("/statistics")
public class Statistics {
    @GetMapping
    public String getSomeStatistics() {
        return "";
    }
}
