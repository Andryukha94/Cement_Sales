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

            reports.merge(company,
                    new OrderReport(company, finalCost),
                    (existing, newReport) -> new OrderReport(company,existing.getTotalPrice() + newReport.getTotalPrice()
                    )
            );

            currentDiscount = Math.max(currentDiscount - stepDiscount, 0);
        }

        return new ArrayList<>(reports.values());
    }
}
