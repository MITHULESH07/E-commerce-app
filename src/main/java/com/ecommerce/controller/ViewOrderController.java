package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderAnalyticsService;
import com.ecommerce.service.OrderReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class ViewOrderController {

    private final OrderReader orderReader;
    private final OrderAnalyticsService analyticsService;

    public ViewOrderController(OrderReader orderReader,
                               OrderAnalyticsService analyticsService) {
        this.orderReader = orderReader;
        this.analyticsService = analyticsService;
    }

    @GetMapping({"", "/"})
    public String viewAllOrders(
            @RequestParam(value = "search", required = false) String search,
            Model model) {

        String normalizedSearch = search == null ? null : search.trim();
        List<Order> orders;

        if (normalizedSearch != null && !normalizedSearch.isEmpty()) {
            orders = orderReader.searchOrders(normalizedSearch);
            model.addAttribute("searchKeyword", normalizedSearch);
            model.addAttribute("searchMessage",
                    orders.isEmpty()
                            ? "No orders found for: " + normalizedSearch
                            : orders.size() + " order(s) found for: " + normalizedSearch);
        } else {
            orders = orderReader.getAllOrders();
        }

        model.addAttribute("orders", orders);
        model.addAttribute("totalRevenue", analyticsService.calculateTotalRevenue(orders));
        model.addAttribute("uniqueProductCount", analyticsService.countUniqueProducts(orders));
        model.addAttribute("pageTitle", "All Orders");

        return "view_orders";
    }
}
