package virtual.pizzeria.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Класс, представляющий собой пиццу
 */
@Data
@RequiredArgsConstructor
public class Pizza {
    /** название пиццы */
    @NotNull
    @Size(min=1, message="Вы должны указать название пиццы")
    private final String name;

    /** цена пиццы */
    @NotNull
    @Size(min=1, message="Вы должны указать цену пиццы")
    private final Double price;

    /** цена пиццы */
    @NotNull
    @Size(min=1, message="Вы должны указать цену пиццы")
    private final List<Ingredient> ingredients;
}
