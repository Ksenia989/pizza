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
@Entity
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

    public Pizza(String id, @NotNull @Size(min = 1, message = "Вы должны указать название пиццы") String name, @NotNull Double price, boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
    }
}
