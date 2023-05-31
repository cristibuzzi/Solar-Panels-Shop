package com.sda.onlineshop.solarpanelsshop.controller;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.Order;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.service.OrderService;
import com.sda.onlineshop.solarpanelsshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/my-orders")
    public String showMyOrdersPage(Model model, Principal principal) {
        model.addAttribute("orders", orderService.findAllByUserEmail(principal.getName()));
        return "orders";
    }

    @GetMapping("/all-orders")
    public String showAll(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("client-order-view/{id}")
    public String showViewOrderPage(@PathVariable("id") int orderId, Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        ClientProfile clientProfile = user.getClientProfile();
        if (clientProfile == null) {
            throw new IllegalArgumentException("Client profile does not exist");
        }
        Optional<Order> optionalOrder = orderService.findByIdAndClientProfile(orderId, clientProfile);
        if (optionalOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }

        model.addAttribute("order", optionalOrder.get());
        model.addAttribute("clientProfile", clientProfile);
        return "order-view";
    }

    @GetMapping("admin-order-view/{id}")
    public String showViewOrderPage(@PathVariable("id") int orderId, Model model) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }

        model.addAttribute("order", optionalOrder.get());
        model.addAttribute("clientProfile", new ClientProfile());
        return "order-view";
    }

    @GetMapping("admin-order-delete/{id}")
    public String deleteOrder(@PathVariable("id") int orderId) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }
        orderService.delete(optionalOrder.get());
        return "redirect:/all-orders";
    }

    @GetMapping("/admin-order-update/{id}")
    public String showUpdateOrderPage(@PathVariable("id") int orderId, Model model) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }

        model.addAttribute("order", optionalOrder.get());
        return "order-update";
    }

    @PostMapping("/admin-order-update/{id}")
    public String updateOrder(@ModelAttribute("order") Order order, @PathVariable("id") int orderId) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }
        optionalOrder.get().setStatus(order.getStatus());
        orderService.update(optionalOrder.get());
        return "redirect:/all-orders";
    }
}
