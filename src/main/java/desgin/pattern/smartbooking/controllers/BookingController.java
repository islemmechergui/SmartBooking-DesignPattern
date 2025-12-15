package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.enums.BookingStatus;
import desgin.pattern.smartbooking.enums.PaymentMethod;
import desgin.pattern.smartbooking.services.BookingFacadeService;
import desgin.pattern.smartbooking.services.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final BookingFacadeService bookingFacadeService;


    public BookingController(BookingService bookingService, BookingFacadeService bookingFacadeService) {
        this.bookingService = bookingService;
        this.bookingFacadeService = bookingFacadeService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingEntity> createBooking(
            @RequestParam Long clientId,
            @RequestParam Long serviceId,
            @RequestParam String paymentMethod,
            @RequestParam String bookingTime) {

        PaymentMethod method = PaymentMethod.valueOf(paymentMethod.toUpperCase());
        LocalDateTime time = LocalDateTime.parse(bookingTime);
        BookingEntity booking = bookingFacadeService.createAndConfirmBooking(clientId, serviceId, time, method);

        return ResponseEntity.ok(booking);
    }

    // Annuler une réservation
    @PostMapping("/cancel/{id}")
    public ResponseEntity<BookingEntity> cancelBooking(@PathVariable Long id) {
        BookingEntity booking = bookingFacadeService.cancelBooking(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public List<BookingEntity> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/search")
    public List<BookingEntity> searchBookings(
            @RequestParam(required = false) String clientName,
            @RequestParam(required = false) BookingStatus status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return bookingService.searchBookings(clientName, status, start, end);
    }

    @GetMapping("/history/{clientId}")
    public List<BookingEntity> getBookingHistory(@PathVariable Long clientId) {
        UserEntity client = new UserEntity();
        client.setId(clientId);
        return bookingService.getBookingHistory(client);
    }
}
