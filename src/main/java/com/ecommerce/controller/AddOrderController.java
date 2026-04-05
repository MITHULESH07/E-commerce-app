package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for CO3: Add Order feature.
 * Handles GET (show form) and POST (submit form) for adding new orders.
 */
@Controller
@RequestMapping("/orders")
public class AddOrderController {

    @Autowired
    private OrderService orderService;

    // Show add order form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("pageTitle", "Add New Order");
        return "add_order";
    }

    // Process add order form submission
    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") Order order,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Add New Order");
            return "add_order";
        }
        orderService.addOrder(order);
        redirectAttributes.addFlashAttribute("successMessage",
            "Order added successfully for " + order.getCustomerName() + "!");
        return "redirect:/orders";
    }
}
