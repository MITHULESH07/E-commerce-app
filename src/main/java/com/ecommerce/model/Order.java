package com.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * JPA Entity representing an Order.
 * Maps to the 'orders' table in MySQL.
 *
 * Schema:
 *   orderid      INT          PRIMARY KEY, AUTO_INCREMENT
 *   customername VARCHAR(100) NOT NULL
 *   productname  VARCHAR(100) NOT NULL
 *   quantity     INT          NOT NULL
 *   price        DOUBLE       NOT NULL
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderId;

    @NotBlank(message = "Customer name is required")
    @Size(max = 100)
    @Column(name = "customername", nullable = false, length = 100)
    private String customerName;

    @NotBlank(message = "Product name is required")
    @Size(max = 100)
    @Column(name = "productname", nullable = false, length = 100)
    private String productName;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;

    public Order() {}

    public Order(String customerName, String productName, Integer quantity, Double price) {
        this.customerName = customerName;
        this.productName  = productName;
        this.quantity     = quantity;
        this.price        = price;
    }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getTotalValue() {
        return (quantity != null && price != null) ? quantity * price : 0.0;
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", customerName='" + customerName +
               "', productName='" + productName + "', quantity=" + quantity +
               ", price=" + price + '}';
    }
}
