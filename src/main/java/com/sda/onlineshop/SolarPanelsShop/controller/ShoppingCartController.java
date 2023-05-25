package com.sda.onlineshop.solarpanelsshop.controller;

import com.sda.onlineshop.solarpanelsshop.model.Product;
import com.sda.onlineshop.solarpanelsshop.service.ProductService;
import com.sda.onlineshop.solarpanelsshop.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/shopping-cart-add/{id}")
    public String addProductToShoppingCart(@PathVariable("id") int id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            shoppingCartService.addProduct(productOptional.get());
        }
        return "redirect:/home?productAddedToCart";
    }

    @GetMapping("/shopping-cart")
    public String showSoppingCart(Model model) {
        model.addAttribute("products", shoppingCartService.getAllProducts());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());
        return "shopping-cart";
    }
}
