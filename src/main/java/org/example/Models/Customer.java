package org.example.Models;

import org.example.Models.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String email;
    private String password;

    private Cart cart;

    private double balance;

    public Customer(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = new Cart(this);
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    public void removeFromCart(Product product){
        cart.removeProduct(product);
    }
}
