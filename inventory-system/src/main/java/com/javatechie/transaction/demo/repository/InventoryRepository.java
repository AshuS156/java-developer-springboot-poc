package com.javatechie.transaction.demo.repository;

import com.javatechie.transaction.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product, Integer>{
}
