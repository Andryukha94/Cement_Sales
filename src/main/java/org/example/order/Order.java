package org.example.order;

public class Order {
    private final String time;
    private final String company;
    private final double weight;

    public Order(String time, String company, double weight) {
        this.time = time;
        this.company = company;
        this.weight = weight;
    }

    public String getTime() {
        return time;
    }
    public String getCompany() {
        return company;
    }
    public double getWeight() {
        return weight;
    }
}
