package desgin.pattern.smartbooking.entites;

import desgin.pattern.smartbooking.enums.TypeNotification;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    private TypeNotification type;
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
