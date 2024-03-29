package virtual.pizzeria.task.statistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.Date;
import java.util.List;

/**
 * Класс статистики, считающий количество заказанных пицц в определенный промежуток времени
 */
@Slf4j
public class PizzaCountRequestHandler extends StatisticsRequestHandler {
    public PizzaCountRequestHandler(Date timeFrom, Date timeTo, OrderRepository orderRepo) {
        super(timeFrom, timeTo, orderRepo);
    }

    @Override
    public ResponseEntity handle(StatisticsRequest request) {
        List<Order> orderStream = getOrdersWithinDateRange();
        int pizzaCount;
        pizzaCount = orderStream.stream().mapToInt(Order::getCountPizzas).sum();
        log.info("Запрос количества проданных пицц за период");
        return ResponseEntity.status(HttpStatus.OK).body("В период c " + super.getTimeFrom().toString() + " по " + super
                .getTimeTo().toString() + "\nБыло заказано " + pizzaCount + " пицц(ы)");
    }
}
