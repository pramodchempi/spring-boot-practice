package com.pramod.productrestapi.controller;

import com.pramod.productrestapi.entities.Product;
import com.pramod.productrestapi.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products/", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/products/{id}")
    @Transactional(readOnly = true)
    @Cacheable("product-cache")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.findById(id).get(); // Optional
    }

    @PostMapping(value = "/products/")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(value = "/products/")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping(value = "/products/{id}")
    @CacheEvict("product-cache")
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}
