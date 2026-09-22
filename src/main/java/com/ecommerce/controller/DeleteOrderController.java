package com.ecommerce.controller;

import com.ecommerce.exception.OrderNotFoundException;
import com.ecommerce.service.OrderWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class DeleteOrderController {

    private final OrderWriter orderWriter;

    public DeleteOrderController(OrderWriter orderWriter) {
        this.orderWriter = orderWriter;
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id,
                              RedirectAttributes redirectAttributes) {
        try {
            orderWriter.deleteOrder(id);
            redirectAttributes.addFlashAttribute(
                    "successMessage", "Order #" + id + " deleted successfully.");
        } catch (OrderNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/orders";
    }
}
