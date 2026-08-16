package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.Auth.OtpRequestDTO;
import com.example.Ecommerce.DTO.Auth.RegisterRequestDTO;
import com.example.Ecommerce.DTO.Auth.RegisterResponseDTO;
import com.example.Ecommerce.DTO.Login.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO requestDTO);

    RegisterResponseDTO register(RegisterRequestDTO requestDTO);

    String verifyOtp(OtpRequestDTO requestDTO);
}