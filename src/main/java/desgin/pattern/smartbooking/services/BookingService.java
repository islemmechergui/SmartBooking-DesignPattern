package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.strategy.PaymentMethod;

import java.time.LocalDateTime;

import java.util.List;

public interface BookingService {
    BookingEntity create(Long clientId, Long serviceId, LocalDateTime time);
    List<BookingEntity> getAll();
    BookingEntity cancel(Long id);

    void confirmBooking(Long bookingId, PaymentMethod paymentMethod);

}
