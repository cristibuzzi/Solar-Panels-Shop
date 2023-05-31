package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAllByUserEmail(String email);

    List<Order> findAll();

    Optional<Order> findByIdAndClientProfile(int id, ClientProfile clientProfile);

    Optional<Order> findById(int id);

    void delete(Order order);

    void update(Order order);
}
