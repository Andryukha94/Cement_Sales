package org.example.converter;

import org.example.order.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HashOrderConverter implements OrderConverter {

    @Override
    public List<Order> convertToOrders(List<String> lines) {
        List<Order> orders = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) continue;

            String[] data = line.split("#");

            String dateTime = data[0].trim();
            String company = data[1].trim();
            double weight = Double.parseDouble(data[2].trim());

            orders.add(new Order(company, weight, LocalDateTime.parse(dateTime)));
        }

        return orders;
    }
}
