package com.sda.onlineshop.solarpanelsshop.model;

import com.sda.onlineshop.solarpanelsshop.model.constant.ClientProfileType;
import jakarta.persistence.*;

@Entity
@Table(name = "client_profile")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ClientProfileType type;

    public ClientProfile() {
    }

    public ClientProfile(String firstName, String lastName, String address, ClientProfileType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "ClientProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }
}