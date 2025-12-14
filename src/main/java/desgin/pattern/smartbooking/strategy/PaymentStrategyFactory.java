package desgin.pattern.smartbooking.strategy;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategyFactory(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy getStrategy(PaymentMethod method) {
        PaymentStrategy strategy = strategies.get(method.name());
        if (strategy == null) {
            throw new IllegalArgumentException("Méthode de paiement non supportée : " + method);
        }
        return strategy;
    }
}
