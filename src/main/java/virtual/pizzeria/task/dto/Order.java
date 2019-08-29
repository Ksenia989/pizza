package virtual.pizzeria.task.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import virtual.pizzeria.task.dto.payment.PaymentMethod;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Класс для данных о заказе (с фронта)
 */
@Data
@Table(name = "order")
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * пиццы в заказе
     */
    @ManyToMany(targetEntity = Pizza.class)
    private List<Pizza> pizzas = new ArrayList<>();

    /**
     * время заказа
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime deliveryDate;

    /**
     * время и дата доставки
     */
//    @NotBlank(message = "Выбор даты и времени доставки обязателен")
    public Date orderDate;

    /**
     * имя заказчика, или того, кому заказывают пиццу
     */
    public String customerName;

    /**
     * адрес доставки
     */
//    @NotBlank(message = "Адрес доставки обязателен")
    public String deliveryAddress;

    /**
     * метод оплаты - CASH и BANK_CARD и BANK_ONLINE_PAYMENT
     */
//    @NotBlank(message = "Указание метода оплаты обязательно")
    public PaymentMethod selectedPaymentMethod;

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    @PrePersist
    void placedAt() {
        this.orderDate = new Date();
    }
}
