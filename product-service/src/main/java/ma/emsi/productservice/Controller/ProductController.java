package ma.emsi.productservice.Controller;


import ma.emsi.productservice.Service.serviceImpl.ProductServiceImp;
import ma.emsi.productservice.dtos.ProductDTO;
import ma.emsi.productservice.module.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO product) {

        return ResponseEntity.created(URI.create("/byId/"+product.getId())).body(productService.saveProduct(product));
    }

    @GetMapping("/productList")
    public ResponseEntity<List<Product>> getAllProductDetails() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")Long id,@RequestBody ProductDTO product){
        return ResponseEntity.ok(productService.editProduct(id,product));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable("id")Long id){
        Product product=productService.getProductById(id);
        if (product!=null){
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
