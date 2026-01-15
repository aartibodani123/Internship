package com.example.simplewebapp.Controller;

import com.example.simplewebapp.model.Product;
import com.example.simplewebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/products")
public class ProductController {
    @Autowired
    ProductService productservice;

    @GetMapping("/")
    public List<Product> getProducts(){
        return productservice.getProducts();
    }

    @RequestMapping("/id")
    public Product getProductByID(@RequestParam(name = "id") int prodId) {
        return productservice.getProductById(prodId);
    }

    @PostMapping ("/create")
    public void addProduct(@RequestBody Product product){
        productservice.addProduct(product);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProductById(@PathVariable int prodId){
        productservice.deleteProductById(prodId);
    }
    //study requestParams


}
