package com.fishy.dashboard.fishdashboard;

public final class Fish {

    public Fish() {
    }

    private long id;

    private int quantity;
    private String name;

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

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
