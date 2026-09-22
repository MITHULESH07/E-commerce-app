package com.ecommerce.service;

import com.ecommerce.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderReader {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    List<Order> searchOrders(String keyword);
}
