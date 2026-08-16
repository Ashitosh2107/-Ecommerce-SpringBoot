package com.example.Ecommerce.DTO.Auth;

import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.Login.LoginResponseDTO;
import com.example.Ecommerce.DTO.Auth.RegisterRequestDTO;
import com.example.Ecommerce.DTO.Auth.RegisterResponseDTO;


import com.example.Ecommerce.DTO.Auth.OtpRequestDTO;
import com.example.Ecommerce.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody LoginRequestDTO requestDTO) {

        return authService.login(requestDTO);
    }

    @PostMapping("/register")
    public RegisterResponseDTO register(
            @Valid @RequestBody RegisterRequestDTO requestDTO) {

        return authService.register(requestDTO);
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(
            @Valid @RequestBody OtpRequestDTO requestDTO) {

        return authService.verifyOtp(requestDTO);
    }
}