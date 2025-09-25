package com.javatechie.transaction.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order{

    @Id
    private int id;

    private  int productId;

    private int quantity;

    private double totalAmount;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double get(){
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
