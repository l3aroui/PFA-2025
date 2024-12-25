package ma.emsi.productservice.Controller;

import ma.emsi.productservice.Service.CategoryService;

import ma.emsi.productservice.dtos.CategoryDTO;
import ma.emsi.productservice.module.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/product/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/saveCategory")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(categoryService.SaveCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategorieById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorie() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}