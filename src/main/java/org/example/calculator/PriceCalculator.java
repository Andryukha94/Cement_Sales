package org.example.calculator;

import org.example.order.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculator {
    public static List<String> calculateOrders(List<Order> orders, double priceKg, double startDiscount, double stepDiscount) {
        Map<String, Double> totalsByCompany = new HashMap<>();

        double currentDiscount = startDiscount;

        for (Order order : orders) {
            double cost = order.getWeight() * priceKg;
            double finalCost = cost - cost * currentDiscount / 100.0;

            totalsByCompany.merge(order.getCompany(), finalCost, Double::sum);

            currentDiscount -= stepDiscount;
            if (currentDiscount < 0) {
                currentDiscount = 0;
            }
        }

        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Double> entry : totalsByCompany.entrySet()) {
            String company = entry.getKey();
            double total = entry.getValue();
            results.add(company + " - " + total);
        }

        return results;
    }
}
