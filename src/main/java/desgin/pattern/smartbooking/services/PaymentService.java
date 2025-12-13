package desgin.pattern.smartbooking.services;

import java.math.BigDecimal;

public interface PaymentService {
    void pay(Long bookingId, String method, BigDecimal amount);

}
