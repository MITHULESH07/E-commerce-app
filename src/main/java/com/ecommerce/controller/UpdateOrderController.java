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
 * Controller for CO4: Update Order feature.
 */
@Controller
@RequestMapping("/orders")
public class UpdateOrderController {

    @Autowired
    private OrderService orderService;

    // Show edit form pre-filled with existing order data
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model,
                               RedirectAttributes redirectAttributes) {
        return orderService.getOrderById(id)
            .map(order -> {
                model.addAttribute("order", order);
                model.addAttribute("pageTitle", "Update Order #" + id);
                return "update_order";
            })
            .orElseGet(() -> {
                redirectAttributes.addFlashAttribute("errorMessage",
                    "Order not found with ID: " + id);
                return "redirect:/orders";
            });
    }

    // Process update form submission
    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable Long id,
                              @Valid @ModelAttribute("order") Order order,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Update Order #" + id);
            return "update_order";
        }
        order.setOrderId(id);
        orderService.updateOrder(order);
        redirectAttributes.addFlashAttribute("successMessage",
            "Order #" + id + " updated successfully!");
        return "redirect:/orders";
    }
}
