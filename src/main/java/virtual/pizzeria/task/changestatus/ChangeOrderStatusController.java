package virtual.pizzeria.task.changestatus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

/**
 * Класс для обновления статуса заказа
 */
@Slf4j
@Controller
@RequestMapping("/changestatus")
public class ChangeOrderStatusController {
    private final OrderRepository orderRepository;

    /**
     * Внедряем объект БД
     * @param orderRepository
     */
    @Autowired
    ChangeOrderStatusController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Здесь обновляем статус
     */
    @PostMapping
    public ResponseEntity changeStatus(@RequestBody ChangeStatus request) {
        Order order = orderRepository.findById(request.getOrderId()).get();
        order.setStatus(request.getStatusToGo());
        log.info("Запрос изменения статуса на " + request.getStatusToGo().getName());
        orderRepository.save(order);
        return ResponseEntity.ok("Статус успешно установлен");
    }
}
