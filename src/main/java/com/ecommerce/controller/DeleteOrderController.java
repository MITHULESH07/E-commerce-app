package com.ecommerce.controller;

import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for CO4: Delete Order feature.
 */
@Controller
@RequestMapping("/orders")
public class DeleteOrderController {

    @Autowired
    private OrderService orderService;

    // Delete order and redirect back to list
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id,
                              RedirectAttributes redirectAttributes) {
        try {
            orderService.deleteOrder(id);
            redirectAttributes.addFlashAttribute("successMessage",
                "Order #" + id + " deleted successfully.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/orders";
    }
}
