package com.ecommerce.service;

import com.ecommerce.exception.OrderNotFoundException;
import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Coordinates order persistence/use cases.
 * Uses constructor injection and focused contracts.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        Order existing = orderRepository.findById(order.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(order.getOrderId()));

        existing.setCustomerName(order.getCustomerName());
        existing.setProductName(order.getProductName());
        existing.setQuantity(order.getQuantity());
        existing.setPrice(order.getPrice());

        return orderRepository.save(existing);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> searchOrders(String keyword) {
        return orderRepository
                .findByCustomerNameContainingIgnoreCaseOrProductNameContainingIgnoreCase(
                        keyword, keyword);
    }
}
