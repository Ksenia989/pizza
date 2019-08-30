package virtual.pizzeria.task.statistics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.Date;
import java.util.List;

/**
 * Класс статистики, считающий количество заказанных пицц в определенный промежуток времени
 */
public class PizzaCountRequestHandler extends StatisticsRequestHandler {
    public PizzaCountRequestHandler(Date timeFrom, Date timeTo, OrderRepository orderRepo) {
        super(timeFrom, timeTo, orderRepo);
    }

    @Override
    public ResponseEntity handle(StatisticsRequest request) {
        List<Order> orderStream = getOrdersWithinDateRange();
        int pizzaCount = 0;
        for (Order order : orderStream) {
            pizzaCount += order.getPizzas().size();
        }// todo lambda or stream
        return ResponseEntity.status(HttpStatus.OK).body("Было заказано " + pizzaCount + " пицц(ы)");
    }
}
