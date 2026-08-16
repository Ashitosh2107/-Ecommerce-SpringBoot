package com.example.Ecommerce.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OtpRequestDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String otp;
}