package com.example.Ecommerce.DTO.Login;

import com.example.Ecommerce.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {

    private Long id;

    private String fullName;

    private String email;

    private Role role;

    private String token;

    private String message;
}