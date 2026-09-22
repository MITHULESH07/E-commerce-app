package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderAnalyticsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class OrderAnalyticsServiceImpl implements OrderAnalyticsService {

    @Override
    public double calculateTotalRevenue(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getTotalValue).sum();
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
