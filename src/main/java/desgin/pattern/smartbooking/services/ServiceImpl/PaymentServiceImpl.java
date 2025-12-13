package desgin.pattern.smartbooking.services.ServiceImpl;


import desgin.pattern.smartbooking.services.PaymentService;
import desgin.pattern.smartbooking.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentServiceImpl(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public void pay(Long bookingId, String method, BigDecimal amount) {

        PaymentStrategy strategy = strategies.get(method);

        if (strategy == null) {
            throw new IllegalArgumentException("Méthode de paiement non supportée");
        }

        strategy.pay(amount);
    }
}
