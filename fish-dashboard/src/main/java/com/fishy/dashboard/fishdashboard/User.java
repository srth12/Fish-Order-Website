package com.fishy.dashboard.fishdashboard;


public class User {

    private long id;

    private String name;

    private double balance;

    public User() {
    }

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
