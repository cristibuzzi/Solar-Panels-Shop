package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.Order;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.repository.OrderRepository;
import com.sda.onlineshop.solarpanelsshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Order> findAllByUserEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        ClientProfile clientProfile = user.getClientProfile();
        if (clientProfile == null) {
            throw new IllegalArgumentException("Client profile does not exist");
        }
        return orderRepository.findAllByClientProfile(clientProfile);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findByIdAndClientProfile(int id, ClientProfile clientProfile) {
        return orderRepository.findByIdAndClientProfile(id, clientProfile);
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
