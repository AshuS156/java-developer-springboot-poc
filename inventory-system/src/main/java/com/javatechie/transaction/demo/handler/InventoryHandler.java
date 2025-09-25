package com.javatechie.transaction.demo.handler;

import com.javatechie.transaction.demo.entity.Product;
import com.javatechie.transaction.demo.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryHandler{

    private InventoryRepository inventoryRepository;

    public InventoryHandler(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public Product getProduct(int id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No Product found for id : {}"+ id));
    }


    public Product updateProduct(Product product) {
        if(product.getPrice()>5000) {
            throw new RuntimeException("DB Crashed.....");
        }
        return inventoryRepository.save(product);
    }
}
