package org.example.Services;

import org.example.Models.Customer;
import org.example.Models.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public Customer login(String email, String password) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(String name, String email, String password, double balance) {
        Customer customer = new Customer(name, email, password, balance);
        customers.add(customer);
    }

    public void removeCustomer(String email) {
        customers.removeIf(customer -> customer.getEmail().equals(email));
    }

    public void updateCustomer(String email, String name, String password, double balance) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                customer.setName(name);
                customer.setPassword(password);
                customer.setBalance(balance);
                break;
            }
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public void addProductToCart(String email, Product product, int quantity) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                customer.addToCart(product, quantity);
                break;
            }
        }
    }

    public void removeProductFromCart(String email, Product product) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                customer.removeFromCart(product);
                break;
            }
        }
    }
}
