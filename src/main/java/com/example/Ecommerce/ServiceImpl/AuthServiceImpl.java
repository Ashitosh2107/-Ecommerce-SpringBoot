package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.Constant.AppConstants.java.ErrorMessages;
import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.Auth.OtpRequestDTO;
import com.example.Ecommerce.DTO.Auth.RegisterRequestDTO;
import com.example.Ecommerce.DTO.Auth.RegisterResponseDTO;
import com.example.Ecommerce.DTO.Login.LoginResponseDTO;
import com.example.Ecommerce.Exceptions.ResourceNotFoundException;
import com.example.Ecommerce.Exceptions.UnauthorizedException;
import com.example.Ecommerce.Model.OtpVerification;
import com.example.Ecommerce.Model.Role;
import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Repository.OtpVerificationRepo;
import com.example.Ecommerce.Repository.RoleRepo;
import com.example.Ecommerce.Repository.UserRepo;
import com.example.Ecommerce.RoleName;
import com.example.Ecommerce.Security.JwtService;
import com.example.Ecommerce.Security.UserPrincipal;
import com.example.Ecommerce.Service.AuthService;
import com.example.Ecommerce.Service.EmailService;
import com.example.Ecommerce.Utils.OtpGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final OtpVerificationRepo otpVerificationRepo;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }

    private String normalizeText(String value) {
        return value.trim();
    }

    private String normalizePassword(String value) {
        return value.trim();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {

        String email = normalizeEmail(requestDTO.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        requestDTO.getPassword()
                )
        );

        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UnauthorizedException(ErrorMessages.INVALID_EMAIL_OR_PASSWORD));

        if (!Boolean.TRUE.equals(user.getActive())) {
            throw new UnauthorizedException(ErrorMessages.ACCOUNT_DISABLED);
        }

        String token = jwtService.generateToken(new UserPrincipal(user));

        LoginResponseDTO response = new LoginResponseDTO();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setToken(token);
        response.setMessage("Login Successful");

        return response;
    }

    @Override
    @Transactional
    public RegisterResponseDTO register(RegisterRequestDTO requestDTO) {

        String email = normalizeEmail(requestDTO.getEmail());
        String fullName = normalizeText(requestDTO.getFullName());
        String password = normalizePassword(requestDTO.getPassword());

        if (userRepo.findByEmail(email).isPresent()) {
            throw new RuntimeException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }

        Role customerRole = roleRepo.findByName(RoleName.CUSTOMER)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND));

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(requestDTO.getPhone());
        user.setRole(customerRole);
        user.setActive(false);
        user.setEmailVerified(false);

        User savedUser = userRepo.save(user);

        String otp = OtpGenerator.generateOtp();

        OtpVerification otpVerification = OtpVerification.builder()
                .email(savedUser.getEmail())
                .otp(otp)
                .expiryTime(LocalDateTime.now().plusMinutes(5))
                .verified(false)
                .build();

        otpVerificationRepo.save(otpVerification);

        emailService.sendOtpEmail(savedUser.getEmail(), otp);

        return RegisterResponseDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getFullName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .message("Registration successful. OTP has been sent to your email.")
                .build();
    }

    @Override
    @Transactional
    public String verifyOtp(OtpRequestDTO requestDTO) {

        String email = normalizeEmail(requestDTO.getEmail());

        OtpVerification otpVerification = otpVerificationRepo
                .findTopByEmailOrderByIdDesc(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("OTP not found"));

        if (otpVerification.getVerified()) {
            return "OTP already verified.";
        }

        if (otpVerification.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new UnauthorizedException("OTP has expired.");
        }

        if (!Objects.equals(otpVerification.getOtp(), requestDTO.getOtp())) {
            throw new UnauthorizedException("Invalid OTP.");
        }

        otpVerification.setVerified(true);
        otpVerificationRepo.save(otpVerification);

        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorMessages.USER_NOT_FOUND));

        user.setActive(true);
        user.setEmailVerified(true);

        userRepo.save(user);

        return "OTP verified successfully.";
    }
}