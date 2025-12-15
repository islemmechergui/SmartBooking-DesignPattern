package desgin.pattern.smartbooking.strategy.gestionPayment;

import java.math.BigDecimal;

public interface PaymentStrategy {
    void pay(BigDecimal amount);
}
