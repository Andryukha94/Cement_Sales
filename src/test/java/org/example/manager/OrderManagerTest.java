package org.example.manager;

import org.example.calculator.PriceCalculator;
import org.example.converter.OrderConverter;
import org.example.file.FileUtil;
import org.example.order.Order;
import org.example.report.OrderReport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderManagerTest {

    @Mock
    private OrderConverter orderConverter;

    @Mock
    private PriceCalculator priceCalculator;

    @Test
    void process_shouldCallDependenciesWithCorrectArguments() {

        String inputPath = "src/main/java/org/resources/orders_hash";
        String outputPath = "src/main/java/org/resources/result";
        double priceKg = 10.0;
        double startDiscount = 50.0;
        double stepDiscount = 5.0;

        List<String> lines = List.of("line1", "line2");
        List<Order> orders = List.of(mock(Order.class));
        List<OrderReport> reports = List.of(mock(OrderReport.class));

        OrderManager manager = new OrderManager(orderConverter, priceCalculator);

        try (MockedStatic<FileUtil> fileUtilMock = mockStatic(FileUtil.class)) {
            fileUtilMock.when(() -> FileUtil.readLines(inputPath)).thenReturn(lines);
            when(orderConverter.convertToOrders(lines)).thenReturn(orders);
            when(priceCalculator.calculateOrders(orders, priceKg, startDiscount, stepDiscount)).thenReturn(reports);

            manager.process(inputPath, outputPath, priceKg, startDiscount, stepDiscount);

            fileUtilMock.verify(() -> FileUtil.readLines(inputPath));
            verify(orderConverter).convertToOrders(lines);
            verify(priceCalculator).calculateOrders(orders, priceKg, startDiscount, stepDiscount);
            fileUtilMock.verify(() -> FileUtil.writeLines(eq(outputPath), anyList()));
        }
    }
}
