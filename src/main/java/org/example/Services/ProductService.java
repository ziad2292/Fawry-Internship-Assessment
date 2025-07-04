package org.example.Services;
import org.example.Models.Products.ExpiryPolicy;
import org.example.Models.Products.Product;
import org.example.Models.Products.ShippingPolicy;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity, ExpiryPolicy expPolicy, ShippingPolicy shipPolicy) {
        Product product = new Product(name, price, quantity, expPolicy, shipPolicy);
        products.add(product);
    }

    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void updateProduct(int id, double price, int quantity) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(price);
                product.setQuantity(quantity);
                break;
            }
        }
    }

    public Product getProduct(int productId){
        for(Product product : products){
            if(product.getId() == productId){
                return product;
            }
        }

        return null;
    }

    public void updateQuantity(int id, int quantity) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setQuantity(quantity);
                break;
            }
        }
    }

    

}
