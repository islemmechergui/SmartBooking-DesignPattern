package desgin.pattern.smartbooking.controllers;

import desgin.pattern.smartbooking.entites.CategoryEntity;
import desgin.pattern.smartbooking.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryEntity create(@RequestBody CategoryEntity category) {
        return categoryService.create(category);
    }

    @GetMapping
    public List<CategoryEntity> getAll() {
        return categoryService.getAll();
    }
}
