package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.BookingRepository;
import desgin.pattern.smartbooking.repositories.ServiceRepository;
import desgin.pattern.smartbooking.repositories.UserRepository;
import desgin.pattern.smartbooking.services.BookingService;
import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.entites.BookingStatus;
import desgin.pattern.smartbooking.services.PaymentService;
import desgin.pattern.smartbooking.strategy.PaymentMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ServiceRepository serviceRepo;
    private final PaymentService paymentService;


    public BookingServiceImpl(BookingRepository bookingRepo,
                              UserRepository userRepo,
                              ServiceRepository serviceRepo, PaymentService paymentService) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.serviceRepo = serviceRepo;
        this.paymentService = paymentService;
    }

    @Override
    public BookingEntity create(Long clientId, Long serviceId, LocalDateTime time) {
        BookingEntity booking = new BookingEntity();
        booking.setClient(userRepo.findById(clientId).orElseThrow());
        booking.setService(serviceRepo.findById(serviceId).orElseThrow());
        booking.setBookingTime(time);
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(LocalDateTime.now());
        return bookingRepo.save(booking);
    }

    @Override
    public List<BookingEntity> getAll() {
        return bookingRepo.findAll();
    }

    @Override
    public BookingEntity cancel(Long id) {
        BookingEntity booking = bookingRepo.findById(id).orElseThrow();
        booking.setStatus(BookingStatus.CANCELLED);
        booking.setUpdatedAt(LocalDateTime.now());
        return bookingRepo.save(booking);
    }

    @Override
    public void confirmBooking(Long bookingId, PaymentMethod paymentMethod) {

        BigDecimal amount = new BigDecimal("150.00");

        paymentService.pay(bookingId, paymentMethod, amount);


    }
}