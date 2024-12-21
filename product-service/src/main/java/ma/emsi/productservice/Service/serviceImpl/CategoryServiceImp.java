package ma.emsi.productservice.Service.serviceImpl;

import ma.emsi.productservice.Repository.CategoryRepo;

import ma.emsi.productservice.Service.CategoryService;
import ma.emsi.productservice.dtos.CategorieDTO;


import ma.emsi.productservice.module.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepo categoryRepository ;
    @Autowired
    public CategoryServiceImp(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category SaveCategory(CategorieDTO categorieDTO){
        Category category=Category.builder()
                .name(categorieDTO.name())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(int id){
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id : " + id));

    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public Category updateCategory(int id, Category updatedCategory) {
        Category existingCategory = getCategory(id);
        existingCategory.setName(updatedCategory.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
            categoryRepository.deleteById(id);
        }
    }
