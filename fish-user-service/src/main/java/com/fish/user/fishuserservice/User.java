package com.fish.user.fishuserservice;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BALANCE")
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
}
