package virtual.pizzeria.task.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getSomeStatistics(@RequestBody StatisticsRequest request) {
        ResponseEntity response;
        StatisticsRequestHandler handler;
        if (request.getType().equals(TaskType.PIZZA_COUNT.getName())) {
            handler = new PizzaCountRequestHandler(request.getTimeFrom(), request.getTimeTo(), orderRepository);
        } else if (request.getType().equals(TaskType.ORDERS_COUNT.getName())) {
            handler = new OrdersCountRequestHandler(request.getTimeFrom(), request.getTimeTo(), orderRepository);
        } else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
            return response;
        }
        response = handler.handle(request);
        return response;
    }
}
