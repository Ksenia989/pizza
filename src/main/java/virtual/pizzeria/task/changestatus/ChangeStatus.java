package virtual.pizzeria.task.changestatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeStatus {
    private OrderStatus statusToGo;
    private Long orderId;
}
