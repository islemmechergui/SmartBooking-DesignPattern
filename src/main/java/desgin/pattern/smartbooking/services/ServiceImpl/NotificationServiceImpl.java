package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.NotificationRepository;
import desgin.pattern.smartbooking.services.NotificationService;
import desgin.pattern.smartbooking.entites.NotificationEntity;
import desgin.pattern.smartbooking.entites.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void notify(UserEntity user, String message) {
        NotificationEntity notification = new NotificationEntity();
        notification.setUser(user);
        notification.setType("IN_APP");
        notification.setMessage(message);
        notification.setIsRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        repository.save(notification);
    }


}
