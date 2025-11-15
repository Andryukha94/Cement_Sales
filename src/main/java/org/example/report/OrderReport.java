package org.example.report;

import org.example.order.Order;

public class OrderReport {
    private final String companyName;
    private final double totalPrice;

    public OrderReport(String companyName, double totalPrice) {
        this.companyName = companyName;
        this.totalPrice = totalPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return companyName + " - " + totalPrice;
    }
}
