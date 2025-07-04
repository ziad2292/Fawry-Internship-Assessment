package org.example.Models.Products;

public class Shippable implements ShippingPolicy{

    private double weight;

    public Shippable(double weight){
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
