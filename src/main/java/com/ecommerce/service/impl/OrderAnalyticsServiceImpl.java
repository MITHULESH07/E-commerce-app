package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderAnalyticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class OrderAnalyticsServiceImpl implements OrderAnalyticsService {

    @Override
    public BigDecimal calculateTotalRevenue(List<Order> orders) {
        return orders.stream()
                .map(Order::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int countUniqueProducts(List<Order> orders) {
        Set<String> products = new HashSet<>();
        for (Order order : orders) {
            if (order.getProductName() != null) {
                products.add(order.getProductName().trim().toLowerCase(Locale.ROOT));
            }
        }
        return products.size();
    }
}
