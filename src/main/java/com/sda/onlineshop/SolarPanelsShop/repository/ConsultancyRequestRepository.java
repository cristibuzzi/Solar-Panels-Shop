package com.sda.onlineshop.solarpanelsshop.repository;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.ConsultancyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultancyRequestRepository extends JpaRepository<ConsultancyRequest, Integer> {

    List<ConsultancyRequest> findAllByClientProfile (ClientProfile clientProfile);

    Optional<ConsultancyRequest> findByIdAndClientProfile(int id, ClientProfile clientProfile);

}

