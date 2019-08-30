package virtual.pizzeria.task.statistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.Date;
import java.util.List;

/**
 * Класс обработки статистики количества заказов за определенный период
 */
@Slf4j
public class OrdersCountRequestHandler extends StatisticsRequestHandler {
    public OrdersCountRequestHandler(Date timeFrom, Date timeTo, OrderRepository orderRepo) {
        super(timeFrom, timeTo, orderRepo);
    }

    @Override
    public ResponseEntity handle(StatisticsRequest request) {
        List<Order> orderStream = getOrdersWithinDateRange();
        int result = orderStream.size();
        log.info("Запрос количество заказов за период");
        return ResponseEntity.status(HttpStatus.OK).body("В период c " + super.getTimeFrom().toString() + " по " + super
                .getTimeTo().toString() + "Было сделано " + result + " заказа(ов)");
    }
}
