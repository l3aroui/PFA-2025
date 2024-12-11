package ma.emsi.productservice.Service;


import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.module.Product;

import java.util.List;

public interface ProductService {
    public Integer saveProduct( ProductDTO product) ;
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public void deleteProduct(Integer id);


}
