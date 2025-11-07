package org.example.calculator;

import org.example.order.Order;
import org.example.report.OrderReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculator {
    public List<OrderReport> calculateOrders(List<Order> orders, double priceKg, double startDiscount, double stepDiscount) {

        Map<String, OrderReport> reports = new HashMap<>();
        double currentDiscount = startDiscount;

        for (Order order : orders) {
            double cost = order.getWeight() * priceKg;
            double finalCost = cost - cost * currentDiscount / 100.0;

            String company = order.getCompany();

            if (reports.containsKey(company)) {
                OrderReport existing = reports.get(company);
                double newTotal = existing.getTotalPrice() + finalCost;
                reports.put(company, new OrderReport(company, newTotal));
            } else {
                reports.put(company, new OrderReport(company, finalCost));
            }

            currentDiscount -= stepDiscount;
            if (currentDiscount < 0) currentDiscount = 0;
        }

        return new ArrayList<>(reports.values());
    }
}
