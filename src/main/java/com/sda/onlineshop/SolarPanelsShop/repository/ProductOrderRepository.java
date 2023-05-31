package com.sda.onlineshop.solarpanelsshop.repository;

import com.sda.onlineshop.solarpanelsshop.model.Order;
import com.sda.onlineshop.solarpanelsshop.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
