package desgin.pattern.smartbooking.strategy.gestionPayment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("WALLET")
public class WalletPayment implements PaymentStrategy {



    @Override
    public void pay(BigDecimal amount) {

    }
}
