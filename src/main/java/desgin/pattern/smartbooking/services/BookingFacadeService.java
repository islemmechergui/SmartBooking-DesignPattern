package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.enums.PaymentMethod;
import desgin.pattern.smartbooking.services.BookingService;
import desgin.pattern.smartbooking.services.NotificationService;
import desgin.pattern.smartbooking.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingFacadeService {

    private final BookingService bookingService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public BookingEntity createAndConfirmBooking(Long clientId, Long serviceId,
                                                 LocalDateTime bookingTime,
                                                 PaymentMethod paymentMethod) {
        BookingEntity booking = bookingService.create(clientId, serviceId, bookingTime);

        bookingService.confirmBooking(booking.getId(), paymentMethod);

        UserEntity client = booking.getClient(); // Supposons que BookingEntity contient le client
        String message = "Votre réservation pour le service "
                + booking.getService().getTitle()
                + " a été confirmée.";
        notificationService.notify(client, message);

        return booking;
    }

    public BookingEntity cancelBooking(Long bookingId) {
        BookingEntity booking = bookingService.cancel(bookingId);

        UserEntity client = booking.getClient();
        String message = "Votre réservation pour le service "
                + booking.getService().getTitle()
                + " a été annulée.";
        notificationService.notify(client, message);

        return booking;
    }


    public List<BookingEntity> getAllBookings() {
        return bookingService.getAll();
    }
}
