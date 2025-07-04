package org.example.Services;

import org.example.Models.Cart;
import org.example.Models.Customer;
import org.example.Models.Products.Product;
import org.example.Models.Products.ShippableItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutService {
    private CustomerService customerService;
    private ProductService productService;
    private ShippingService shippingService;

    public CheckoutService(ProductService productService, CustomerService customerService, ShippingService shippingService) {
        this.customerService = customerService;
        this.productService = productService;
        this.shippingService = shippingService;
    }

    public void addProductToCart(String email, int productId, int quantity) {
        if (productService.getProduct(productId).getQuantity() < quantity) {
            throw new RuntimeException("Product is out of stock");
        }
        Product product = productService.getProduct(productId);
        customerService.addProductToCart(email, product, quantity);
        productService.updateQuantity(productId, productService.getProduct(productId).getQuantity() - quantity);

    }

    public void removeProductFromCart(String email, int productId) {
        Product product = productService.getProduct(productId);
        customerService.removeProductFromCart(email, product);
        productService.updateQuantity(productId, productService.getProduct(productId).getQuantity() + 1);
    }

    public void setTotalPrice(Customer customer) {
        HashMap<Product, Integer> products = customer.getCart().getProducts();
        double totalPrice = 0;
        for (Product product : products.keySet()) {
            if(product.getExpiryPolicy().getExpiryDate().isBefore(LocalDate.now())) {
                throw new RuntimeException("Product is expired");
            }

            List<Product> shippableProducts = new ArrayList<>();
            if(product.getShippingPolicy().isShippable()) {
                shippableProducts.add(product);
                shippingService.addShippableItem((ShippableItem) product);
            }
            
            totalPrice += product.getPrice() * products.get(product);
        }
        customer.getCart().setTotalPrice(totalPrice);
    }

    public double getTotalPrice(Customer customer) {
        setTotalPrice(customer);
        return customer.getCart().getTotalPrice() + customer.getCart().getShippingCost();
    }


    public void checkout(Customer customer) {

        double totalPrice = getTotalPrice(customer);

        if (customer.getBalance() < totalPrice) {
            throw new RuntimeException("Insufficient balance");
        }

        if (customer.getCart().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }


        customer.setBalance(customer.getBalance() - totalPrice);
        customer.setCart(new Cart(customer));
    }
}
