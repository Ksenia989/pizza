package virtual.pizzeria.task.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Класс, представляющий собой пиццу
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Pizza {
    @Id
    private final String id;

    /**
     * название пиццы
     */
    @NotNull
    @Size(min = 1, message = "Вы должны указать название пиццы")
    private final String name;

    /**
     * цена пиццы
     */
    @NotNull
    private final Double price;
}
