package virtual.pizzeria.task.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Класс, представляющий собой пиццу
 */
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    @NonNull
    private long id;

    /**
     * название пиццы
     */
    @NotNull
    @NonNull
    @Size(min = 1, message = "Вы должны указать название пиццы")
    private String name;

    /**
     * цена пиццы
     */
    @NotNull
    @NonNull
    private Double price;

    private transient int count = 0;
}
