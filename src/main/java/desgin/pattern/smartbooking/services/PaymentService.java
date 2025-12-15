package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.enums.PaymentMethod;

import java.math.BigDecimal;

public interface PaymentService {

    void pay(Long bookingId, PaymentMethod method, BigDecimal amount);
}
