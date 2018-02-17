package com.fish.order.fishorderservice;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "FISH_ID")
    private long fishId;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "QUANTITY")
    private int quantity;

    public Order() {
    }

    public Order(long userId, long fishId, double price, int quantity) {
        this.userId = userId;
        this.fishId = fishId;
        this.price = price;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getUserId() {
        return userId;
    }

    public long getFishId() {
        return fishId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
