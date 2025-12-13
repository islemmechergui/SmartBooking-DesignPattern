package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingEntity create(@RequestParam Long clientId,
                                @RequestParam Long serviceId,
                                @RequestParam String time) {
        LocalDateTime bookingTime = LocalDateTime.parse(time);
        return bookingService.create(clientId, serviceId, bookingTime);
    }

    @GetMapping
    public List<BookingEntity> getAll() {
        return bookingService.getAll();
    }

    @PutMapping("/cancel/{id}")
    public BookingEntity cancel(@PathVariable Long id) {
        return bookingService.cancel(id);
    }
}
