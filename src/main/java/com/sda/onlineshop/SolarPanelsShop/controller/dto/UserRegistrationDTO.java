package com.sda.onlineshop.solarpanelsshop.controller.dto;


import com.sda.onlineshop.solarpanelsshop.utils.FieldMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
})
public class UserRegistrationDTO {
    @Email
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String confirmPassword;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

