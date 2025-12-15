package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByClient_NameContainingIgnoreCase(String clientName);

    List<BookingEntity> findByStatus(BookingStatus status);

    List<BookingEntity> findByBookingTimeBetween(LocalDateTime start, LocalDateTime end);

    List<BookingEntity> findByClientOrderByBookingTimeDesc(UserEntity client);
}
