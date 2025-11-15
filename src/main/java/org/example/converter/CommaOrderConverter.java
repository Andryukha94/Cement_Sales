package org.example.converter;

import org.example.order.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommaOrderConverter implements OrderConverter {

    @Override
    public List<Order> convertToOrders(List<String> lines) {
        return lines.stream()
                .filter(line -> line != null && !line.trim().isEmpty())
                .map(line -> line.split(","))
                .map(data -> new Order(
                        data[1].trim(),
                        Double.parseDouble(data[2].trim()),
                        LocalDateTime.parse(data[0].trim())
                ))
                .toList();
    }
}