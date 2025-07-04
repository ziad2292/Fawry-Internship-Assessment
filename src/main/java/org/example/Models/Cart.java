package org.example.Models;

import org.example.Models.Products.Product;

import java.util.HashMap;

public class Cart {

    private HashMap<Product, Integer> products;
    private Customer customer;
    private final int shippingCost = 10;
    private double totalPrice = shippingCost;

    public Cart(Customer customer) {
        this.customer = customer;
        this.products = new HashMap<>();
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getShippingCost(){
        return shippingCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
    
}
