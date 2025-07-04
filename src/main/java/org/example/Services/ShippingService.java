package org.example.Services;
import org.example.Models.Products.ShippableItem;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    private List<ShippableItem> shippableItems;

    public ShippingService() {
        this.shippableItems = new ArrayList<>();
    }
    
    public void addShippableItem(ShippableItem shippableItem) {
        shippableItems.add(shippableItem);
    }
    
}
