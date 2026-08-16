package com.example.Ecommerce.DTO.Auth;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {
    private Long id;
    private String Firstname;
    private String Lastname;
    private String email;
    private String role;
    private String message;
}
