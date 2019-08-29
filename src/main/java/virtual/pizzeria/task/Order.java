package virtual.pizzeria.task;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * Класс для данных о заказе (с фронта)
 */
@Data
public class Order {
    /** пиццы в заказе */
    public List<Pizza> pizzas;

    /** комбо наборы (из пицц) */
    public List<PizzaCombo> pizzaCombos;

    /** время заказа */
    public Date orderDate = new Date();

    /** время и дата доставки */
    @NotBlank(message = "Выбор даты и времени доставки обязателен")
    public Date deliveryDate;

    /** имя заказчика, или того, кому заказывают пиццу */
    public String customerName;

    /** адрес доставки */
    @NotBlank(message = "Адрес доставки обязателен")
    public String deliveryAddress;

    /** метод оплаты - CASH и BANK_CARD и BANK_ONLINE_PAYMENT */
    @NotBlank(message = "Указание метода оплаты обязательно")
    public PaymentMethod selectedPaymentMethod;
}
