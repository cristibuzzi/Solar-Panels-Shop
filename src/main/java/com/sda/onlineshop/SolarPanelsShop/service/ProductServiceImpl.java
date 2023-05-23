package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.Product;
import com.sda.onlineshop.solarpanelsshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
