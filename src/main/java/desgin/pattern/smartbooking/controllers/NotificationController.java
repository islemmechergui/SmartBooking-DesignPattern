package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.UserEntity;
import desgin.pattern.smartbooking.services.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notify")
    public void notifyUser(@RequestBody UserEntity user,
                           @RequestParam String message) {
        notificationService.notify(user, message);
    }
}
