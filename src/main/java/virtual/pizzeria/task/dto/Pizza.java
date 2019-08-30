package virtual.pizzeria.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Класс, представляющий собой пиццу
 */
@Data
@Entity
@AllArgsConstructor
public class Pizza {
    @Id
    private String id;

    /**
     * название пиццы
     */
    @NotNull
    @Size(min = 1, message = "Вы должны указать название пиццы")
    private String name;

    /**
     * цена пиццы
     */
    @NotNull
    private Double price;

    private boolean active;

    public Pizza() {
    }
}
