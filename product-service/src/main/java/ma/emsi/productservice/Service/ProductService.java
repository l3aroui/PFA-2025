package ma.emsi.productservice.Service;


import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.module.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDTO product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);

}
