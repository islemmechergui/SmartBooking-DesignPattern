package desgin.pattern.smartbooking.entites;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity provider;

    @ManyToOne
    private CategoryEntity category;

    private String title;
    private String description;
    private BigDecimal price;
    private Integer durationMinutes;
    private String status;
    private LocalDateTime createdAt;
}

