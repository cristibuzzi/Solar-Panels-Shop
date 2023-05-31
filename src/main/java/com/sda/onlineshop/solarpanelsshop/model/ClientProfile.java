package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ClientProfileType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "client_profile")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @NotNull(message = "First name must be not null!")
//    @NotBlank(message = "First name must be not blank!")
//    @Size(min = 2)
    @Column(name = "first_name")
    private String firstName;

//    @NotNull(message = "Last name must be not null!")
//    @NotBlank(message = "Last name must be not blank!")
//    @Size(min = 2)
    @Column(name = "last_name")
    private String lastName;

//    @NotNull(message = "Address must be not null!")
//    @NotBlank(message = "Last name must be not blank!")
//    @Size(min = 10)
    @Column(name = "address")
    private String address;

//    @NotNull(message = "Client profile type must be not null!")
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ClientProfileType type;


    public ClientProfile() {
    }

    public ClientProfile(String firstName, String lastName, String address, ClientProfileType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientProfileType getType() {
        return type;
    }

    public void setType(ClientProfileType type) {
        this.type = type;
    }
}
