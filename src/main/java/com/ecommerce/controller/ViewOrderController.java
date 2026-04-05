package com.ecommerce.controller;

import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ecommerce.model.Order;

/**
 * Controller for CO3: View Orders and Search features.
 * Handles listing all orders and searching by keyword.
 */
@Controller
@RequestMapping("/orders")
public class ViewOrderController {

    @Autowired
    private OrderService orderService;

    // List all orders (also serves as home/index)
    @GetMapping({"", "/"})
    public String viewAllOrders(@RequestParam(value = "search", required = false) String search,
                                Model model) {
        String normalizedSearch = search == null ? null : search.trim();
        List<Order> orders;
        if (normalizedSearch != null && !normalizedSearch.isEmpty()) {
            orders = orderService.searchOrders(normalizedSearch);
            model.addAttribute("searchKeyword", normalizedSearch);
            model.addAttribute("searchMessage",
                orders.isEmpty()
                    ? "No orders found for: " + normalizedSearch
                    : orders.size() + " order(s) found for: " + normalizedSearch);
        } else {
            orders = orderService.getAllOrders();
        }
        model.addAttribute("orders", orders);
        model.addAttribute("pageTitle", "All Orders");
        return "view_orders";
    }
}
