package virtual.pizzeria.task;

import org.springframework.data.repository.CrudRepository;
import virtual.pizzeria.task.dto.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
