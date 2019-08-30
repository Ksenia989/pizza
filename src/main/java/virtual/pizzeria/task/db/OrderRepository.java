package virtual.pizzeria.task.db;

import org.springframework.data.repository.CrudRepository;
import virtual.pizzeria.task.dto.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
