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
    PREPARING("готовится"),
    READY("готов"),
    DELIVERING("доставляется"),
    DELIVERED("доставлен");

    /**
     * имя для более удобного отображения
     */
    private String name;
}
