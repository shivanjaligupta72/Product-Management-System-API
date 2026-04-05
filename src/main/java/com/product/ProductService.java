package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Add new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update product
    public Product updateProduct(int id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    // Find by name
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    // Find by price less than
    public List<Product> findByPriceLessThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }
}
