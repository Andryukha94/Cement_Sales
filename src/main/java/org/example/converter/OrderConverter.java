package org.example.converter;

import org.example.order.Order;
import java.util.List;

public interface OrderConverter {
    List<Order> convertToOrders(List<String> lines);
}