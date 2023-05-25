package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // @NotNull(message = "Name must be not null!")
    // @NotBlank(message = "Name must be not blank!")
    // @Size(min = 2)
    @Column(name = "name")
    private String name;

    @NotNull(message = "Email must be not blank!")
    @NotBlank(message = "Email must be not blank!")
    @Email
    @Column(name = "email")
    private String email;

    // @NotNull(message = "Password must be not null!")
    // @NotBlank(message = "Password must be not blank123!")
    // @Size(min = 8, max = 50)
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    @Column(name = "password")
    private String password;

    // @NotNull(message = "Role must be not null!")
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    // @NotNull(message = "Phone number must be not null!")
    // @NotBlank(message = "Phone number be not blank!")
    // @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "client_profile_id")
    private ClientProfile clientProfile;

    public User() {
    }

    public User(String name, String email, String password, UserRole role, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber=phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
