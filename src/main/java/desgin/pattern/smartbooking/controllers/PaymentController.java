package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public void pay(@RequestParam Long bookingId,
                    @RequestParam String method,
                    @RequestParam BigDecimal amount) {
        paymentService.pay(bookingId, method, amount);
    }
}
