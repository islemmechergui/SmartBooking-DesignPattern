package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
