package virtual.pizzeria.task.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import virtual.pizzeria.task.dto.payment.PaymentMethod;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс для данных о заказе (с фронта)
 */
@Data
@Table(name = "orders")
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * автогенерируемый id
     */
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
     * Сумма заказа
     */
    public double paymentSum;

    /**
     * время и дата доставки
     */
    @NotNull(message = "Выбор даты и времени доставки обязателен")
    public Date orderDate;

    /**
     * имя заказчика, или того, кому заказывают пиццу
     */
    public String customerName;

    /**
     * адрес доставки
     */
    @NotBlank(message = "Адрес доставки обязателен")
    public String deliveryAddress;

    /**
     * метод оплаты - CASH и BANK_CARD и BANK_ONLINE_PAYMENT
     */
    @NotNull(message = "Выбор метода оплаты обязателен")
    public PaymentMethod selectedPaymentMethod;

    /**
     * статус заказа. Изначально - получен
     */
    public OrderStatus status;

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    /**
     * перед отправкой в БД записываем текущее время
     */
    @PrePersist
    void placedAt() {
        this.orderDate = new Date();
        this.status = OrderStatus.RECEIVED;
    }
}
