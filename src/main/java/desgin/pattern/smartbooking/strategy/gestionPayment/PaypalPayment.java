package desgin.pattern.smartbooking.strategy.gestionPayment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("PAYPAL")
public class PaypalPayment implements PaymentStrategy {



    @Override
    public void pay(BigDecimal amount) {

    }
}
