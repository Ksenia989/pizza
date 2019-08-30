package virtual.pizzeria.task.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import virtual.pizzeria.task.db.OrderRepository;

/**
 * Получение статистики по определенной дате
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    private final OrderRepository orderRepository;

    @Autowired
    StatisticsController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public BasicResponse getSomeStatistics(@RequestBody StatisticsRequest request) {
        BasicResponse response = new BasicResponse();
        StatisticsRequestHandler handler;
        if (request.getType().equals(TaskType.PIZZA_COUNT.getName())) {
            handler = new PizzaCountRequestHandler(request.getTimeFrom(), request.getTimeTo());
        } else if(request.getType().equals(TaskType.ORDERS_COUNT.getName())) {
            handler = new OrdersCountRequestHandler(request.getTimeFrom(), request.getTimeTo(), orderRepository);
        } else {
            response.setStatus(500);
            return response;
        }
        response = handler.handle(request);
        response.setStatus(200);
        return response;
    }
}
