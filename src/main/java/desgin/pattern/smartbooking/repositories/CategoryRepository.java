package desgin.pattern.smartbooking.repositories;

import desgin.pattern.smartbooking.entites.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
