package virtual.pizzeria.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
* Инградиенты для пицц
**/
@Data
@RequiredArgsConstructor
public class Ingredient {
    /** название инградиента */
    private final String name;
}
