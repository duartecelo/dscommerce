package com.duartecelo.dscommerce.repositories;

import com.duartecelo.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
