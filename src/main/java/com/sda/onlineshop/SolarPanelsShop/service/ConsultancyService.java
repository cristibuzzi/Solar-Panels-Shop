package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.ConsultancyRequest;
import com.sda.onlineshop.solarpanelsshop.model.Order;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyProductsType;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyRoofType;

import java.util.List;
import java.util.Optional;

public interface ConsultancyService {

    List<ConsultancyRequest> findAllByUserEmail(String email);

    List<ConsultancyRequest> findAll();

    String consultancyRequest(double averageMonthlyConsumption, ConsultancyRoofType roofType, ConsultancyProductsType productsType);

    void create(ConsultancyRequest consultancyRequest);

    Optional<ConsultancyRequest> findByIdAndClientProfile(int id, ClientProfile clientProfile);

    List<ConsultancyRequest> findAllByClientProfile(ClientProfile clientProfile);
}
