package org.example;

import org.example.Models.Products.*;
import org.example.Models.Cart;
import org.example.Models.Customer;
import org.example.Services.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        ShippingService shippingService = new ShippingService();
        CustomerService customerService = new CustomerService();
        CheckoutService checkoutService = new CheckoutService(productService, customerService, shippingService);

        customerService.addCustomer("ahmad", "ahmad@gmail.com", "ahmad123", 10000);
        customerService.addCustomer("ali", "ali@gmail.com", "ali123", 5000);

        productService.addProduct("Cheese", 20, 100, new Expirable(LocalDate.of(2026, 12, 5)), new Shippable(5));
        productService.addProduct("Biscuits", 10, 50, new Expirable(LocalDate.of(2027, 12, 5)), new Shippable(3));
        productService.addProduct("TV", 100, 20, new NonExpirable(), new Shippable(50));
        productService.addProduct("Mobile Scratch Card", 50, 200, new NonExpirable(), new NonShippable());

        Customer loggedinCustomer = customerService.login("ahmad@gmail.com", "ahmad123");

        /*for(Product product: productService.getProducts()){
            System.out.println(product.getId());
        }*/
        //Assuming the an interactive user would know the id of the products he needs throw the previous foreach loop
        checkoutService.addProductToCart(loggedinCustomer.getEmail(), 1, 2);

        System.out.println("Order Subtotal: " + (checkoutService.getTotalPrice(loggedinCustomer) - loggedinCustomer.getCart().getShippingCost()));

        System.out.println("Shipping Fees: " + loggedinCustomer.getCart().getShippingCost());

        System.out.println("Paid Amount: " + checkoutService.getTotalPrice(loggedinCustomer));

        checkoutService.checkout(loggedinCustomer);




    }
}