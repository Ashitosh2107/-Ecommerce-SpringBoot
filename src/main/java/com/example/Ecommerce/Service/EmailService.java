package com.example.Ecommerce.Service;

public interface EmailService {

    void sendWelcomeEmail(String name, String to);

    void sendOtpEmail(String to, String otp);
}