package org.example.Models.Products;

import java.time.LocalDate;

public class NonExpirable implements ExpiryPolicy{
    @Override
    public boolean isExpirable() {
        return false;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }
}
