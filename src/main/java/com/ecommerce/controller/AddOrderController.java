package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderWriter;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class AddOrderController {

    private final OrderWriter orderWriter;

    public AddOrderController(OrderWriter orderWriter) {
        this.orderWriter = orderWriter;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("pageTitle", "Add New Order");
        return "add_order";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") Order order,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Add New Order");
            return "add_order";
        }
        orderWriter.addOrder(order);
        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Order added successfully for " + order.getCustomerName() + "!");
        return "redirect:/orders";
    }
}
