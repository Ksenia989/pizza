package virtual.pizzeria.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Класс, представляющий собой комбо-наборы из пицц
 */
@Data
@RequiredArgsConstructor
public class PizzaCombo {
    /** название комбо */
    private final String name;

    /** цена комбо */
    private final Double price;

    /** список пицц, входящих в комбо */
    private final List<Pizza> pizzas;
}
