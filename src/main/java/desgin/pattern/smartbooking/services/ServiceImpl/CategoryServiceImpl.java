package desgin.pattern.smartbooking.services.ServiceImpl;

import desgin.pattern.smartbooking.repositories.CategoryRepository;
import desgin.pattern.smartbooking.services.CategoryService;
import desgin.pattern.smartbooking.entites.CategoryEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryEntity create(CategoryEntity category) {
        category.setCreatedAt(LocalDateTime.now());
        return repository.save(category);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return repository.findAll();
    }
}