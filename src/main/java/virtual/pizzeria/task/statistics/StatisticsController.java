package virtual.pizzeria.task.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Получение статистики по определенной дате
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @GetMapping
    public BasicResponse getSomeStatistics(StatisticsRequest request) {
        BasicResponse response = new BasicResponse();
        StatisticsRequestHandler handler;
        if (request.getType().equals(TaskType.PIZZA_COUNT.getName())) {
            handler = new PizzaCountRequestHandler();
        } else if(request.getType().equals(TaskType.ORDERS_COUNT.getName())) {
            handler = new OrdersCountRequestHandler();
        } else {
            response.setCode(500);
            return response;
        }
        response = handler.handle(request);
        return response;
    }
}
