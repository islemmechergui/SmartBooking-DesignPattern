package desgin.pattern.smartbooking.services;

import desgin.pattern.smartbooking.entites.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryEntity category);
    List<CategoryEntity> getAll();
}
