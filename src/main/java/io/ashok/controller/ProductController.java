package io.ashok.controller;

import io.ashok.entity.Product;
import io.ashok.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/name/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/products/add")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void removeProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }
}
