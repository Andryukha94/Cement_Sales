package org.example.manager;

import org.example.converter.OrderConverter;
import org.example.calculator.PriceCalculator;
import org.example.file.FileUtil;
import org.example.order.Order;
import org.example.report.OrderReport;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private final OrderConverter orderConverter;
    private final PriceCalculator priceCalculator;

    public OrderManager(OrderConverter orderConverter, PriceCalculator priceCalculator) {
        this.orderConverter = orderConverter;
        this.priceCalculator = priceCalculator;
    }

    public void process(String inputPath, String outputPath, double priceKg, double startDiscount, double stepDiscount) {

        List<String> lines = FileUtil.readLines(inputPath);
        List<Order> orders = orderConverter.convertToOrders(lines);
        List<OrderReport> reports = priceCalculator.calculateOrders(orders, priceKg, startDiscount, stepDiscount);

        List<String> results = new ArrayList<>();
        for (OrderReport report : reports) {
            results.add(report.toString());
        }

        FileUtil.writeLines(outputPath, results);
    }
}