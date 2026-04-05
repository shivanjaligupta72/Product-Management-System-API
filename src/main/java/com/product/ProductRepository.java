
package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository 
    extends JpaRepository<Product, Integer> {
    
    // Find by name
    List<Product> findByName(String name);
    
    // Find by price less than
    List<Product> findByPriceLessThan(double price);
    
    // Find by quantity greater than
    List<Product> findByQuantityGreaterThan(int quantity);
}
