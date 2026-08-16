package com.example.Ecommerce.DTO.Seller;

import com.example.Ecommerce.DTO.User.UserResponseDTO;

public class SellerResponseDTO extends UserResponseDTO {

    private String shopName;
    private String shopAddress;
    private boolean verified;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}