package ma.emsi.productservice.Service;



import ma.emsi.productservice.dtos.CategoryDTO;

import ma.emsi.productservice.module.Category;

import java.util.List;

public interface CategoryService {

    Category SaveCategory(CategoryDTO categoryDTO) ;
    Category getCategory(int id);
    List<Category> getAllCategories();
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);
}
