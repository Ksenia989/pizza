package virtual.pizzeria.task.dto.payment;

/**
 * enum для методов оплаты
 */
public enum PaymentMethod {
    /** наличный рассчет */ CASH,
    /** безналичный рассчет */ BANK_CARD,
    /** онлайн оплата */ BANK_ONLINE_PAYMENT
}
