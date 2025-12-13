package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}
