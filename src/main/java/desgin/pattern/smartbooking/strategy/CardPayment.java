package desgin.pattern.smartbooking.strategy;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("CARD")
public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paiement par carte : " + amount);
    }
}
