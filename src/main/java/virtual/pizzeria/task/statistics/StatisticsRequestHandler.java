package virtual.pizzeria.task.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Абстрактный класс обработки статистики
 */
@AllArgsConstructor
@Getter
public abstract class StatisticsRequestHandler {
    private Date timeFrom;
    private Date timeTo;
    private OrderRepository orderRepo;

    public abstract ResponseEntity handle(StatisticsRequest request);

    /**
     * метод, вычисляющий заказы, находящиеся между присланными датами
     * @return
     */
    public List<Order> getOrdersWithinDateRange() {
        return IteratorUtils.getStreamFromIterator(orderRepo.findAll().iterator()).
                filter(order ->
                        order.getOrderDate().after(timeFrom) && order.getOrderDate().before(timeTo)
                ).collect(Collectors.toList());
    }
}
