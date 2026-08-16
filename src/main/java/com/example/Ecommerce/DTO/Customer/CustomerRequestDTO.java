package com.example.Ecommerce.DTO.Customer;

import com.example.Ecommerce.DTO.User.UserRequestDTO;

public class CustomerRequestDTO extends UserRequestDTO {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}