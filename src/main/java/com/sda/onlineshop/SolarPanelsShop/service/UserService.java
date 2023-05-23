package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.constant.UserRole;
import com.sda.onlineshop.solarpanelsshop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {


    Optional<User> findByEmail(String email);

    void createUser(String email, String password, UserRole role, String name ,String phoneNumber);

}
