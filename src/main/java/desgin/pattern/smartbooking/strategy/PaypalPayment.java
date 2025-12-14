package desgin.pattern.smartbooking.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("PAYPAL")
public class PaypalPayment implements PaymentStrategy {



    @Override
    public void pay(BigDecimal amount) {

    }
}
