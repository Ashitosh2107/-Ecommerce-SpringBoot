package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendWelcomeEmail(String name, String to) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ashitoshpatil62@gmail.com");
        message.setTo(to);
        message.setSubject("Welcome to Ecommerce");

        message.setText("""
                Hello %s,

                Welcome to our Ecommerce Application.

                Your account has been created successfully.

                Thank you for registering.

                Regards,
                Ecommerce Team
                """.formatted(name));

        mailSender.send(message);
    }

    @Override
    public void sendOtpEmail(String to, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ashitoshpatil62@gmail.com");
        message.setTo(to);
        message.setSubject("OTP Verification");

        message.setText("""
                Dear User,

                Your OTP is: %s

                This OTP is valid for 5 minutes.

                Please do not share this OTP with anyone.

                Regards,
                Ecommerce Team
                """.formatted(otp));

        mailSender.send(message);
    }
}