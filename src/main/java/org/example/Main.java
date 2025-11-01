package org.example;

import org.example.OrderManager.OrderManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/java/org/resources/orders";
        String outputFile = "src/main/java/org/resources/result";

        double price = 500.0;
        double startDiscount = 50.0;
        double stepDiscount = 5.0;

        OrderManager manager = new OrderManager(inputFile, outputFile, price, startDiscount, stepDiscount);
        manager.process();
    }
}
