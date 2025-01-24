package org.example.frontendthymeleaf.controllers;

import org.example.frontendthymeleaf.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController {

    private final RestTemplate restTemplate;
    @Autowired
    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/productForm")
    public String product(){
        return "productForm";
    }

    @GetMapping("/products")
    public String showAllProduct(Model model){
        String url="http://product-service/api/v1/product/productList";
        Product[] products=restTemplate.getForObject(url,Product[].class);
        model.addAttribute("products",products);
        return "products";
    }

    @PostMapping("/addProducts")
    public String saveProduct(@ModelAttribute Product product){
        String url="http://product-service/api/v1/product/saveProduct";
        restTemplate.postForObject(url,product,Product.class);
        return "redirect:product";
    }
}
