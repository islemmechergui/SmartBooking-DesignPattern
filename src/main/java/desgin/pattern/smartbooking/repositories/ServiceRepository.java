package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
