package com.ecommerce.service;

/**
 * Backward-compatible facade composed from focused interfaces.
 * ISP: callers can depend on OrderReader or OrderWriter directly.
 */
public interface OrderService extends OrderReader, OrderWriter {
}
