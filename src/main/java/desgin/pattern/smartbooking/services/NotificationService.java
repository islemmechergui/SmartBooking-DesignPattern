package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.UserEntity;

public interface NotificationService {
    void notify(UserEntity user, String message);
}
