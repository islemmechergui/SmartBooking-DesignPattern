package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.BookingEntity;

import java.time.LocalDateTime;

import java.util.List;

public interface BookingService {
    BookingEntity create(Long clientId, Long serviceId, LocalDateTime time);
    List<BookingEntity> getAll();
    BookingEntity cancel(Long id);
}
