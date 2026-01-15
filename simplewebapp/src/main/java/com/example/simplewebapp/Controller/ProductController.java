package com.example.simplewebapp.Controller;

import com.example.simplewebapp.model.Product;
import com.example.simplewebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productservice;

    @GetMapping
    public List<Product> getProducts(){
        return productservice.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductByID(@PathVariable int prodId) {
        return productservice.getProductById(prodId);
    }

    @PostMapping ("/create")
    public void addProduct(@RequestBody Product product){
        productservice.addProduct(product);
    }

    @DeleteMapping("/{prodId}")
    public void deleteProductById(@PathVariable int prodId){
        productservice.deleteProductById(prodId);
    }
    //study requestParams

    @PutMapping
    public void updateProduct(@RequestBody Product prod){
        productservice.updateProduct(prod);
    }


}
