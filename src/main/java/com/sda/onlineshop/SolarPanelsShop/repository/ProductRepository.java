package com.sda.onlineshop.solarpanelsshop.repository;

import com.sda.onlineshop.solarpanelsshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
