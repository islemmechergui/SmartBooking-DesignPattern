package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.BookingRepository;
import desgin.pattern.smartbooking.repositories.ServiceRepository;
import desgin.pattern.smartbooking.repositories.UserRepository;
import desgin.pattern.smartbooking.services.BookingService;
import desgin.pattern.smartbooking.entites.BookingEntity;
import desgin.pattern.smartbooking.entites.BookingStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final ServiceRepository serviceRepo;

    public BookingServiceImpl(BookingRepository bookingRepo,
                              UserRepository userRepo,
                              ServiceRepository serviceRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.serviceRepo = serviceRepo;
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
}