package com.example.Ecommerce.DTO.Auth;

import com.example.Ecommerce.Model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private String message;
}