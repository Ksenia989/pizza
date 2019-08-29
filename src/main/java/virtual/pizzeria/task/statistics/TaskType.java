package virtual.pizzeria.task.statistics;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Класс для предоставления статистики о заказах
 */
@Getter
@RequiredArgsConstructor
public enum TaskType {
    /**
     * Количество заказанных пицц в определенный период
     */
    PIZZA_COUNT("pizzacount"),

    /**
     * Количество заказов в определенный период
     */
    ORDERS_COUNT("orderscount");

    private final String name;
}
