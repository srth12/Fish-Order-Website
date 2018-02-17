package com.fish.order.fishorderservice;

import javax.persistence.*;

@Entity
@Table(name = "FISH")
public final class Fish {

    public Fish() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    public Fish(int quantity, String name, double price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public Fish(long id, int quantity, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
