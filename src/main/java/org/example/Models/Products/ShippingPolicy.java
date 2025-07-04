package org.example.Models.Products;

public interface ShippingPolicy {
    boolean isShippable();

    double getWeight();
}
