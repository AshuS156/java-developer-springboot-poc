package com.javatechie.transaction.demo.handler;


import com.javatechie.transaction.demo.entity.Order;
import com.javatechie.transaction.demo.repository.OrderRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
public class OrderHandler{

    private OrderRepository orderRepository;

    public OrderHandler(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
