package com.example.Ecommerce.Model;

import com.example.Ecommerce.Model.User;
import jakarta.persistence.Entity;

@Entity
public class Seller extends User {

    private String shopName;

    private String shopAddress;

    private boolean verified;

}