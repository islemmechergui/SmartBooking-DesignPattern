package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
