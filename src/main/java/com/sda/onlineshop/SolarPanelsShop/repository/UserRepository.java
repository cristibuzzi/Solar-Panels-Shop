package com.sda.onlineshop.solarpanelsshop.repository;

import com.sda.onlineshop.solarpanelsshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
