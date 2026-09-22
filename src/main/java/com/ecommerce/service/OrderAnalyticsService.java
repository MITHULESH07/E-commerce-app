package com.ecommerce.service;

import com.ecommerce.model.Order;
import java.util.List;

public interface OrderAnalyticsService {
    double calculateTotalRevenue(List<Order> orders);
    int countUniqueProducts(List<Order> orders);
}
