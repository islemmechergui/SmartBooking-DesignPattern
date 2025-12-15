package desgin.pattern.smartbooking.strategy.gestionPayment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("CARD")
public class CardPayment implements PaymentStrategy {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paiement par carte : " + amount);
    }
}
