package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
