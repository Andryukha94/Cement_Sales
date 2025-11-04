package org.example;

import org.example.manager.OrderManager;

public class Main {
    public static void main(String[] args) throws Exception {

        String inputFile = "src/main/java/org/resources/orders";
        String outputFile = "src/main/java/org/resources/result";

        double priceKg = 10;
        double startDiscount = 50.0;
        double stepDiscount = 5.0;

        OrderManager.process(inputFile, outputFile, priceKg, startDiscount, stepDiscount);
    }
}
