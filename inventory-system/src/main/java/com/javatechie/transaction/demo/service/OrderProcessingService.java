package com.javatechie.transaction.demo.service;

import com.javatechie.transaction.demo.entity.Order;
import com.javatechie.transaction.demo.entity.Product;
import com.javatechie.transaction.demo.handler.InventoryHandler;
import com.javatechie.transaction.demo.handler.OrderHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService{

    private OrderHandler orderHandler;

    private InventoryHandler inventoryHandler;

    public OrderProcessingService(OrderHandler orderHandler,InventoryHandler inventoryHandler){
        this.orderHandler = orderHandler;
        this.inventoryHandler = inventoryHandler;
    }

    @Transactional(readOnly = false , propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Order placeAnOrder(Order order) {

        // get the product from Inventory
         Product product = inventoryHandler.getProduct(order.getProductId());

        // validate teh available product
        validateInventoryStock(product, order);

        // update the total price in Order Entity
        order.setTotalAmount(product.getPrice()* order.getQuantity());

        // save the order
        final Order order1 = orderHandler.saveOrder(order);

        // update the stock quantity in Inventory table
        updateInventoryStock(product,order);

        return  order1;

    }

    private void validateInventoryStock(Product product , Order order) {
        if(order.getQuantity() > product.getStockQuantity() ) {
            throw new RuntimeException("Insufficient product in Inventory .....");
        }
    }

    private void updateInventoryStock(Product product , Order order) {
        product.setStockQuantity(product.getStockQuantity() - order.getQuantity());
        Product product1 = inventoryHandler.updateProduct(product);

    }
}
