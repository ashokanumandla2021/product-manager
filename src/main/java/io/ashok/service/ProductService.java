package io.ashok.service;

import io.ashok.entity.Product;
import io.ashok.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ProductService implements Serializable {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        productRepository.save(existingProduct);
        return existingProduct;
    }
}
