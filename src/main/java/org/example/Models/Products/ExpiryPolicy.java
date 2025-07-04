package org.example.Models.Products;

import java.time.LocalDate;

public interface ExpiryPolicy {
    boolean isExpirable();

    LocalDate getExpiryDate();
}
