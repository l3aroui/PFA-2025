package ma.emsi.productservice.Service.serviceImpl;


import ma.emsi.productservice.Service.CategorieService;
import ma.emsi.productservice.Service.ProductService;
import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.Repository.ProductRepo;
import ma.emsi.productservice.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepo repository ;
    private final CategorieService categorieService ;
    @Autowired
    public ProductServiceImp(ProductRepo repository, CategorieService categorieService) {
        this.repository = repository;
        this.categorieService = categorieService;
    }

    public Integer editProduct(Product product) {
        return repository.save(product).getId();
    }

    @Override
    public Integer saveProduct(ProductDTO product) {
        Product productToSave = new Product();
        productToSave.setName(product.name());
        productToSave.setQuantity(product.quantity());
        productToSave.setDescription(product.description());
        productToSave.setPrice(product.price());
        productToSave.setCategorie(categorieService.getCategorie(product.id()));
        return repository.save(productToSave).getId();
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);

    }
}
