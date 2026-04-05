package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET - All products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET - Single product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Add product
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product) {
        Product saved = productService.addProduct(product);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT - Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {
        return ResponseEntity.ok(
            productService.updateProduct(id, product));
    }

    // DELETE - Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(
            "Product deleted successfully");
    }
}
