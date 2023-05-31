package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.ConsultancyRequest;
import com.sda.onlineshop.solarpanelsshop.model.Order;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyProductsType;
import com.sda.onlineshop.solarpanelsshop.model.constant.ConsultancyRoofType;
import com.sda.onlineshop.solarpanelsshop.repository.ConsultancyRequestRepository;
import com.sda.onlineshop.solarpanelsshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultancyServiceImpl implements ConsultancyService {
    private final ConsultancyRequestRepository consultancyRequestRepository;
    private final UserRepository userRepository;

    public ConsultancyServiceImpl(ConsultancyRequestRepository consultancyRequestRepository, UserRepository userRepository) {
        this.consultancyRequestRepository = consultancyRequestRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<ConsultancyRequest> findAllByUserEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        ClientProfile clientProfile = user.getClientProfile();
        if (clientProfile == null) {
            throw new IllegalArgumentException("Client profile does not exist");
        }
        return consultancyRequestRepository.findAllByClientProfile(clientProfile);
    }

    @Override
    public List<ConsultancyRequest> findAll() {
        return consultancyRequestRepository.findAll();
    }

    @Override
    public String consultancyRequest(double averageMonthlyConsumption, ConsultancyRoofType roofType, ConsultancyProductsType productsType) {
        return null;
    }

    @Override
    public void create(ConsultancyRequest consultancyRequest) {
        consultancyRequestRepository.save(consultancyRequest);
    }


    @Override
    public Optional<ConsultancyRequest> findByIdAndClientProfile(int id, ClientProfile clientProfile) {
        return consultancyRequestRepository.findByIdAndClientProfile(id, clientProfile);
    }

    @Override
    public List<ConsultancyRequest> findAllByClientProfile(ClientProfile clientProfile) {
        return consultancyRequestRepository.findAllByClientProfile(clientProfile);
    }
}
