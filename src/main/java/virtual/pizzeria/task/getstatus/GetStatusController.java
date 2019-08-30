package virtual.pizzeria.task.getstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import virtual.pizzeria.task.db.OrderRepository;
import virtual.pizzeria.task.dto.Order;

@Controller
@RequestMapping("/getstatus")
public class GetStatusController {
    private final OrderRepository orderRepository;

    @Autowired
    GetStatusController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Здесь обновляем статус
     */
    @GetMapping
    public ResponseEntity getStatus(@RequestParam Long id) {
        Order order = orderRepository.findById(id).get();
        return ResponseEntity.ok("Статус: " + order.getStatus().getName());
    }
}
