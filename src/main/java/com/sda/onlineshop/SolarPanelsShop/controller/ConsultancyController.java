package com.sda.onlineshop.solarpanelsshop.controller;

import com.sda.onlineshop.solarpanelsshop.model.ClientProfile;
import com.sda.onlineshop.solarpanelsshop.model.ConsultancyRequest;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.service.ConsultancyService;
import com.sda.onlineshop.solarpanelsshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ConsultancyController {
    private final ConsultancyService consultancyService;
    private final UserService userService;

    public ConsultancyController(ConsultancyService consultancyService, UserService userService) {
        this.consultancyService = consultancyService;
        this.userService = userService;
    }

    @GetMapping("/consultancy")
    public String showConsultancyPage(Model model) {
        model.addAttribute("consultancy", new ConsultancyRequest());
        return "consultancy";
    }

    @PostMapping("/consultancy")
    public String addConsultancy(
            @ModelAttribute("consultancy")
            @Valid ConsultancyRequest consultancyRequest,
            Principal principal,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "consultancy";
        }
        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        ClientProfile clientProfile = user.getClientProfile();
        consultancyRequest.setClient(clientProfile);
        consultancyService.create(consultancyRequest);
        return "redirect:/consultancy?success";
    }

    @GetMapping("/my-consultancies")
    public String showMyOrdersPage(Model model, Principal principal) {
        model.addAttribute("consultancies", consultancyService.findAllByUserEmail(principal.getName()));
        return "consultancy";
    }

    @GetMapping("/show-consultancy")
    public String showAll(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<ConsultancyRequest> consultancyRequestList = consultancyService.findAllByClientProfile(user.getClientProfile());

        model.addAttribute("consultancies", consultancyRequestList);
        return "show-consultancy";
    }

    @GetMapping("client-consultancies-view/{id}")
    public String showViewConsultancyPage(@PathVariable("id") int id, Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        ClientProfile clientProfile = user.getClientProfile();
        if (clientProfile == null) {
            throw new IllegalArgumentException("Client profile does not exist");
        }
        Optional<ConsultancyRequest> optionalConsultancyRequest = consultancyService.findByIdAndClientProfile(id, clientProfile);
        if (optionalConsultancyRequest.isEmpty()) {
            throw new IllegalArgumentException("Consultancy not found");
        }

        model.addAttribute("consultancy", optionalConsultancyRequest.get());
        model.addAttribute("clientProfile", clientProfile);
        return "client-view-consultancies";
    }
}
