package org.example.manager;

import org.example.converter.OrderConverter;
import org.example.calculator.PriceCalculator;
import org.example.file.FileUtil;
import org.example.order.Order;

import java.util.List;

public class OrderManager {

    public static void process(String inputPath, String outputPath, double priceKg, double startDiscount, double stepDiscount) {

        List<String> lines = FileUtil.readLines(inputPath);

        OrderConverter converter = new OrderConverter();
        List<Order> orders = converter.convertToOrders(lines);

        List<String> results = PriceCalculator.calculateOrders(orders, priceKg, startDiscount, stepDiscount);

        FileUtil.writeLines(outputPath, results);
    }
}