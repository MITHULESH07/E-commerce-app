package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderReader;
import com.ecommerce.service.OrderWriter;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class UpdateOrderController {

    private final OrderReader orderReader;
    private final OrderWriter orderWriter;

    public UpdateOrderController(OrderReader orderReader, OrderWriter orderWriter) {
        this.orderReader = orderReader;
        this.orderWriter = orderWriter;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model,
                               RedirectAttributes redirectAttributes) {
        return orderReader.getOrderById(id)
                .map(order -> {
                    model.addAttribute("order", order);
                    model.addAttribute("pageTitle", "Update Order #" + id);
                    return "update_order";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute(
                            "errorMessage", "Order not found with ID: " + id);
                    return "redirect:/orders";
                });
    }

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
        orderWriter.updateOrder(order);
        redirectAttributes.addFlashAttribute(
                "successMessage", "Order #" + id + " updated successfully!");
        return "redirect:/orders";
    }
}
