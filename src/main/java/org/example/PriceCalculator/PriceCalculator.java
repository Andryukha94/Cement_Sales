package org.example.PriceCalculator;

import org.example.order.Order;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    public static List<String> calculateOrders(List<Order> orders, double price, double startDiscount, double stepDiscount) {
        List<String> results = new ArrayList<>();

        for (Order order : orders) {
            double cost = order.getWeight() * price / 50;
            results.add(order.getCompany() + " - " + (cost - cost * startDiscount / 100));
            startDiscount -= stepDiscount;
        }

        return results;
    }
}
