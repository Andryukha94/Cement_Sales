package org.example.converter;

import org.example.order.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class OrderConverter {

    public List<Order> convertToOrders(List<String> lines) {
        List<Order> orders = new ArrayList<>();

        for (String line : lines) {
            String[] data = line.split(",");
            String dateTimeStr = data[0];
            String company = data[1];
            double weight = Double.parseDouble(data[2]);

            LocalDateTime orderDateTime = LocalDateTime.parse(dateTimeStr);
            orders.add(new Order(company, weight, orderDateTime));
        }

        return orders;
    }
}
