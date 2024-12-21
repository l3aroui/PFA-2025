package ma.emsi.productservice.Controller;


import ma.emsi.productservice.Service.serviceImpl.ProductServiceImp;
import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDTO product) {
        Integer id = productService.saveProduct(product);
        return new ResponseEntity<String>("Product with'" + id + "'has been saved", HttpStatus.OK);
    }

    @GetMapping("/productList")
    public ResponseEntity<List<Product>> getAllProductDetails() {
        List<Product> list = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {

        Product p = productService.getProductById(id);
        return new ResponseEntity<>(p , HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String>updateProduct(@PathVariable("id")Integer id,@RequestBody ProductDTO product){
        Product pFromDb = productService.getProductById(id);
        pFromDb.setName(product.name());
        pFromDb.setPrice(product.price());
        pFromDb.setQuantity(product.quantity());
        pFromDb.setDescription(product.description());
        Integer id1 = productService.editProduct(pFromDb);
        return new ResponseEntity<String>("Student with '"+id1+"'has been updated",HttpStatus.OK);

    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable("id")int id){
        Product product=productService.getProductById(id);
        if (product!=null){
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
