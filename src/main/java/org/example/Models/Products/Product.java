package org.example.Models.Products;

public class Product implements ShippableItem{

    private static int nextId = 1;
    private final int id;
    private String name;

    private double price;

    private int quantity;

    private ExpiryPolicy expiryPolicy;

    private ShippingPolicy shippingPolicy;

    public Product(String name, double price, int quantity, ExpiryPolicy expPolicy, ShippingPolicy shipPolicy){
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryPolicy = expPolicy;
        this.shippingPolicy = shipPolicy;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return shippingPolicy.getWeight();
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpirable(){
        return expiryPolicy.isExpirable();
    }

    public boolean isShippable(){
        return shippingPolicy.isShippable();
    }

    public ExpiryPolicy getExpiryPolicy() {
        return expiryPolicy;
    }

    public ShippingPolicy getShippingPolicy() {
        return shippingPolicy;
    }
}
