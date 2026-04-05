package com.ecommerce.repository;

import com.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA Repository for Order entity.
 * Provides CRUD operations + custom search queries.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Search by customer name (case-insensitive, partial match)
    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);

    // Search by product name (case-insensitive, partial match)
    List<Order> findByProductNameContainingIgnoreCase(String productName);

    // Search by either customer name or product name without case sensitivity
    List<Order> findByCustomerNameContainingIgnoreCaseOrProductNameContainingIgnoreCase(
            String customerName,
            String productName
    );
}
