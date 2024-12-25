package ma.emsi.productservice.Service.serviceImpl;



import ma.emsi.productservice.Service.CategoryService;
import ma.emsi.productservice.Service.ProductService;
import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.Repository.ProductRepo;

import ma.emsi.productservice.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepo productRepo ;
    private final CategoryService categoryService ;
    @Autowired
    public ProductServiceImp(ProductRepo productRepo, CategoryService categoryService) {
        this.productRepo = productRepo;
        this.categoryService = categoryService;
    }

    public Product editProduct(Long id, ProductDTO productU) {
        Product product=productRepo.findById(id).orElseThrow(()->new RuntimeException("product not exist"));
        product.setDescription(productU.getDescription());
        product.setQuantity(productU.getQuantity());
        product.setPrice(productU.getPrice());
        product.setName(productU.getName());
        return productRepo.save(product);
    }

    @Override
    public Product saveProduct(ProductDTO product){
        Product productToSave = new Product();
        productToSave.setName(product.name());
        productToSave.setQuantity(product.quantity());
        productToSave.setDescription(product.description());
        productToSave.setPrice(product.price());
        productToSave.setCategory(categoryService.getCategory(product.id()));
        return productRepo.save(productToSave);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(()->new RuntimeException("product not exist"));
    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productRepo.existsById(productId)) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
        // Delete the product
        productRepo.deleteById(productId);
    }
}
