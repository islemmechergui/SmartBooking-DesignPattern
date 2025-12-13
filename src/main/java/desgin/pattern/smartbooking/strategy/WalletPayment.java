package desgin.pattern.smartbooking.strategy;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component("WALLET")
public class WalletPayment implements PaymentStrategy {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paiement Wallet : " + amount);
    }
}
