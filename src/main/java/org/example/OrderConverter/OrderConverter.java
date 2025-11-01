package org.example.OrderConverter;

import org.example.order.Order;
import java.util.List;
import java.util.ArrayList;

public class OrderConverter {

    public static List<Order> convertToOrders(List<String> lines) {
        List<Order> orders = new ArrayList<>();

        for (String line : lines) {
            String[] data = line.split(",");
            orders.add(new Order(data[0], data[1], Double.parseDouble(data[2])));
        }

        return orders;
    }

}
