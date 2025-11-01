package org.example.OrderManager;

import org.example.OrderConverter.OrderConverter;
import org.example.PriceCalculator.PriceCalculator;
import org.example.file.FileUtil;
import org.example.order.Order;

import java.util.List;

public class OrderManager {
    private final String inputPath;
    private final String outputPath;
    private final double price;
    private final double startDiscount;
    private final double stepDiscount;

    public OrderManager (String inputPath, String outputPath, double price, double stratDiscount, double stepDiscount) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.price = price;
        this.startDiscount = stratDiscount;
        this.stepDiscount = stepDiscount;
    }

    public void process() throws Exception {
        List<String> lines = FileUtil.readLines(inputPath);
        System.out.println("Прочитано строк:" + lines.size());

        List<Order> orders = OrderConverter.convertToOrders(lines);
        System.out.println("Заказов создано:" + orders.size());

        List<String> results = PriceCalculator.calculateOrders(orders, price, startDiscount, stepDiscount);
        System.out.println("Результат:" + results.size());

        FileUtil.writeLines(outputPath, results);
    }
}