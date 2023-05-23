package com.sda.onlineshop.solarpanelsshop.controller;

import com.sda.onlineshop.solarpanelsshop.controller.dto.UserRegistrationDTO;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.model.constant.UserRole;
import com.sda.onlineshop.solarpanelsshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminRegistrationController {

    private final UserService userService;

    public AdminRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin-register")
    public String showAdminRegisterPage(){
        return "/admin-register";
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @PostMapping("/admin-register")
    public String registerAdminAccount(
            @ModelAttribute("user")
            @Valid UserRegistrationDTO userRegistrationDTO,
            BindingResult bindingResult
    )
    {
        Optional<User> userOptional = userService.findByEmail(userRegistrationDTO.getEmail());
        if(userOptional.isPresent()){
            bindingResult.rejectValue("email",null,"Email already exists");
        }
        if(bindingResult.hasErrors()){
            return "admin-register";
        }
        userService.createUser(
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.getPassword(),
                UserRole.ADMIN,
                userRegistrationDTO.getName(),
                userRegistrationDTO.getPhoneNumber()
        );
        return "redirect:/admin-register?success";
    }
}
