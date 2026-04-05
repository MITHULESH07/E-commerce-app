package com.ecommerce.service;

import com.ecommerce.model.Order;
import java.util.List;
import java.util.Optional;

/**
 * Service interface defining all business operations for Order management.
 */
public interface OrderService {

    // Add a new order
    Order addOrder(Order order);

    // Retrieve all orders
    List<Order> getAllOrders();

    // Find a single order by ID
    Optional<Order> getOrderById(Long id);

    // Update an existing order
    Order updateOrder(Order order);

    // Delete an order by ID
    void deleteOrder(Long id);

    // Search orders by customer name or product name
    List<Order> searchOrders(String keyword);
}
