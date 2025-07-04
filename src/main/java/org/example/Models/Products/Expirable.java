package org.example.Models.Products;

import java.time.LocalDate;

public class Expirable implements ExpiryPolicy{

    private LocalDate expiryDate;

    public Expirable(LocalDate expDate){
        this.expiryDate = expDate;
    }

    @Override
    public boolean isExpirable() {
        return true;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
