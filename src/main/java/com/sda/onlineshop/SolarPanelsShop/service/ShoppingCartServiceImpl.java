package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.*;
import com.sda.onlineshop.solarpanelsshop.model.constant.OrderStatus;
import com.sda.onlineshop.solarpanelsshop.repository.OrderRepository;
import com.sda.onlineshop.solarpanelsshop.repository.ProductOrderRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.MessagingException;
import java.util.*;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final String ORDER_PREFIX = "GREEN-ORD-";
    private final Map<Product, Integer> cart = new LinkedHashMap<>();
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;
    private final MailService mailService;

    public ShoppingCartServiceImpl(UserService userService, OrderRepository orderRepository, ProductOrderRepository productOrderRepository, MailService mailService) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
        this.mailService = mailService;
    }

    @Override
    public void addProduct(Product product) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (cart.containsKey(product)) {
            if (cart.get(product) == 1) {
                cart.remove(product);
            } else {
                cart.put(product, cart.get(product) - 1);
            }
        }
    }

    @Override
    public void clearProducts() {
        cart.clear();
    }

    @Override
    public double totalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if (entry.getKey().getPromoPrice() == null) {
                totalPrice += entry.getValue() * entry.getKey().getPrice();
            } else {
                totalPrice += entry.getValue() * entry.getKey().getPromoPrice();
            }

        }
        return totalPrice;
    }

    @Override
    public void checkOut(String userEmail) {
        User user = userService.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        ClientProfile clientProfile = user.getClientProfile();
        if (clientProfile == null) {
            throw new IllegalArgumentException("Client profile does not exist");
        }

        Order newOrder = new Order();
        newOrder.setOrderNumber(ORDER_PREFIX + new Random().nextInt(10000000));
        newOrder.setDateOfOrder(new Date());
        newOrder.setStatus(OrderStatus.REGISTERED);
        newOrder.setTotalAmount(totalPrice());
        newOrder.setClientProfile(clientProfile);
        orderRepository.save(newOrder);

        for (Map.Entry<Product, Integer> entry : getAllProducts().entrySet()) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setOrder(newOrder);
            productOrder.setProduct(entry.getKey());
            productOrder.setQuantity(entry.getValue());
            productOrderRepository.save(productOrder);
        }

        try {
            mailService.sendEmail
                    (
                            "cristi_panels_shop@yahoo.com",
                            userEmail,
                            "You have a new Order",
                            "We hope you were pleased with your experience with us!"
                    );
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        cart.clear();
    }

    @Override
    public Map<Product, Integer> getAllProducts() {
        return Collections.unmodifiableMap(cart);
    }
}
