package model;

import java.util.ArrayList;

public class Order {
    private int id;
    private Customer customer;
    ArrayList<Order> order = new ArrayList<>();
    
    public Order(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", id=" + id + ", order=" + order + "]";
    }

    
    
}
