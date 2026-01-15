package com.example.simplewebapp.service;

import com.example.simplewebapp.model.Product;
import com.example.simplewebapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
//    List<Product> products= new ArrayList<>(Arrays.asList
//                    (new Product(101,"Iphone",50000),
//                    new Product(102,"Watch",40000),
//                    new Product(103,"Airpods",5000))) ;
    public List<Product>  getProducts(){
        return repo.findAll();
//        return products;
    }

    public Product getProductById(int prodId) {
//        for(Product p:products){
//            if(p.getProdId()==prodId){
//                return p;
//            }
//        }
//        return products.stream()
//                .filter(p->p.getProdId()==prodId)
//                .findFirst()
//                .get();
        return repo.findById(prodId).orElse(new Product());
    }
    public void addProduct(Product product){
//        products.add(product);
        repo.save(product);

    }

    public void deleteProductById(int prodId){
//        Iterator<Product> it=products.iterator();
//        while(it.hasNext()){
//            if(it.next().getProdId()==prodId){
//                it.remove();
//            }
//        }
        repo.deleteById(prodId);
    }

    public void updateProduct(Product prod) {
//        int index=0;
//        for(int i=0;i<products.size();i++){
//            if(products.get(i).getProdId()==prod.getProdId()){
//                index=i;
//            }
//                }
//        products.set(index,prod);
        repo.save(prod);
    }
}
