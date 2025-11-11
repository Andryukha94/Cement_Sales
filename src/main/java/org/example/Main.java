package org.example;

import org.example.calculator.PriceCalculator;
import org.example.converter.OrderConverter;
import org.example.converter.comma.CommaOrderConverter;
import org.example.converter.hash.HashOrderConverter;
import org.example.manager.OrderManager;

public class Main {
    public static void main(String[] args) throws Exception {

        String inputFile = "src/main/java/org/resources/orders_hash";
        String outputFile = "src/main/java/org/resources/result";

        double priceKg = 10;
        double startDiscount = 50.0;
        double stepDiscount = 5.0;

        OrderConverter converter;
        if (inputFile.contains("hash")) {
            converter = new HashOrderConverter();
        } else {
            converter = new CommaOrderConverter();
        }

        PriceCalculator calculator = new PriceCalculator();
        OrderManager manager = new OrderManager(converter, calculator);
        manager.process(inputFile, outputFile, priceKg, startDiscount, stepDiscount);
    }
}
