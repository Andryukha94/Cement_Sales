package org.example.order;

import java.time.LocalDateTime;

public class Order {
    private final LocalDateTime date;
    private final String companyName;
    private final double weight;

    public Order(String company, double weight, LocalDateTime date) {
        this.date = date;
        this.companyName = company;
        this.weight = weight;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public String getCompany() {
        return companyName;
    }
    public double getWeight() {
        return weight;
    }
}
