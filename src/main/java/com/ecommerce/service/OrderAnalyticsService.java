package com.ecommerce.service;

import com.ecommerce.model.Order;
import java.math.BigDecimal;
import java.util.List;

public interface OrderAnalyticsService {
    BigDecimal calculateTotalRevenue(List<Order> orders);
    int countUniqueProducts(List<Order> orders);
}
