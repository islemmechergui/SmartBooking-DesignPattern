package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.strategy.PaymentMethod;

import java.math.BigDecimal;

public interface PaymentService {

    void pay(Long bookingId, PaymentMethod method, BigDecimal amount);
}
