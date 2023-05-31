package com.sda.onlineshop.solarpanelsshop.controller;

import com.sda.onlineshop.solarpanelsshop.model.Product;
import com.sda.onlineshop.solarpanelsshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add-product")
    public String showAddProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-product";
        }
        productService.create(product);
        return "redirect:/add-product?success";
    }

    @GetMapping("/update-product/{id}")
    public String showUpdateProductPage(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow();
        model.addAttribute("product", product);

        return "update-product";
    }

    @PostMapping("/update-product/{id}")
    public String updateProduct(@PathVariable("id") int id, @Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "update-product";
        }

        Product existingProduct = productService.findById(id)
                .orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPromoPrice(product.getPromoPrice());
        existingProduct.setMainImageURL(product.getMainImageURL());

        productService.update(id,existingProduct);

        return "redirect:/";
    }
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/";
    }
}
