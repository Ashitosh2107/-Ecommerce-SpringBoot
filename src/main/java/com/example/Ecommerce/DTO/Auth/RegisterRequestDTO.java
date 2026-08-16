package com.example.Ecommerce.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
@NotBlank(message="first name is required")
@Size(min=2,max=50,message = "first name must be between 2 and 50 characters")
    private String fullName;

@NotBlank(message = "email is requird")
@Email(message = "please enter a valid email address")
@Size(max=100,message = "email cannot exceed 100 characters")
    private String email;

@NotBlank(message = "password is requird ")
@Size(min=8,max=20,message = "password must be between 8 and 20 characters")
    private String password;
    private String phone;


}