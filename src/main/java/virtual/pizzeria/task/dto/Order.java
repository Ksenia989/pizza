package virtual.pizzeria.task.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import virtual.pizzeria.task.changestatus.OrderStatus;
import virtual.pizzeria.task.dto.payment.PaymentMethod;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @OneToMany(targetEntity = Pizza.class)
    @NotNull
    @Size(min = 1, message = "В заказе должна быть как минимум одна пицца")
    private List<Pizza> pizzas = new ArrayList<>();

    /**
     * время заказа
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
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
    @NotBlank(message = "Имя пользователя обязательно")
    @Length(min = 1, message = "Вы должны указать имя пользователя")
    public String customerName;

    /**
     * адрес доставки
     */
    @NotBlank(message = "Адрес доставки обязателен")
    @Length(min = 1, message = "Вы должны указать адрес доставки")
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

    /**
     * Количество пицц в заказе
     */
    public int countPizzas;

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
