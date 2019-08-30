package virtual.pizzeria.task.statistics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.Date;
import java.util.List;

public class OrdersCountRequestHandler extends StatisticsRequestHandler {
    public OrdersCountRequestHandler(Date timeFrom, Date timeTo, OrderRepository orderRepo) {
        super(timeFrom, timeTo, orderRepo);
    }

    @Override
    public ResponseEntity handle(StatisticsRequest request) {
        List<Order> orderStream = getOrdersWithinDateRange();
        int result = orderStream.size();
        return ResponseEntity.status(HttpStatus.OK).body("Было сделано " + result + " заказа(ов)");
    }
}
