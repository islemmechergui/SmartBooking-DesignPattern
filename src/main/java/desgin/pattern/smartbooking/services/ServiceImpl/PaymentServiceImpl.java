package desgin.pattern.smartbooking.services.serviceImpl;

import desgin.pattern.smartbooking.services.PaymentService;
import desgin.pattern.smartbooking.strategy.PaymentMethod;
import desgin.pattern.smartbooking.strategy.PaymentStrategy;
import desgin.pattern.smartbooking.strategy.PaymentStrategyFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategyFactory factory;

    public PaymentServiceImpl(PaymentStrategyFactory factory) {
        this.factory = factory;
    }




    @Override
    public void pay(Long bookingId, PaymentMethod method, BigDecimal amount) {

        PaymentStrategy strategy = factory.getStrategy(method);

        strategy.pay(amount);

    }
}
