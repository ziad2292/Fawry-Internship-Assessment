package org.example.Models.Products;

public class NonShippable implements ShippingPolicy{

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
