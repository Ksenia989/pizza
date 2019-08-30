package virtual.pizzeria.task.changestatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Статусы заказа
 */
@AllArgsConstructor
@Getter
public enum OrderStatus {
    RECEIVED("получен"),
    PREPARING("готовиться"),
    READY("готов"),
    DELIVERING("доставляется"),
    DELIVERED("доставлен");

    private String name;
}
