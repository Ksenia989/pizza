package virtual.pizzeria.task.statistics;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    private final OrderRepository orderRepository;

    /**
     * Внедняем объект бд - заказы
     * @param orderRepository
     */
    @Autowired
    StatisticsController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity getSomeStatistics(@RequestBody StatisticsRequest request) {
        ResponseEntity response;
        // интерфейс - обработчик запроса статистики
        StatisticsRequestHandler handler;
        log.info("Получение статистики (количество пицц или заказов)");
        switch (request.getType()) {
            case PIZZA_COUNT:
                log.info("Запрос статистики на количество пицц");
                handler = new PizzaCountRequestHandler(request.getTimeFrom(), request.getTimeTo(), orderRepository);
                break;
            case ORDERS_COUNT:
                log.info("Запрос статистики на количество заказов");
                handler = new OrdersCountRequestHandler(request.getTimeFrom(), request.getTimeTo(), orderRepository);
                break;
            default:
                // если нет такой константы, то плохой запрос
                response = new ResponseEntity(HttpStatus.BAD_REQUEST);
                return response;
        }
        response = handler.handle(request);
        return response;
    }
}
