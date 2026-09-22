package com.ecommerce.service;

import com.ecommerce.model.Order;

public interface OrderWriter {
    Order addOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
