package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.User.UserRequestDTO;
import com.example.Ecommerce.DTO.User.UserResponseDTO;
import com.example.Ecommerce.Exceptions.EmailAlreadyExistException;
import com.example.Ecommerce.Exceptions.InvalidCredentialsException;
import com.example.Ecommerce.Exceptions.ProductNotFoundException;
import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Repository.UserRepo;
import com.example.Ecommerce.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO saveUser(UserRequestDTO requestDTO) {

        if (userRepo.existsByEmail(requestDTO.getEmail())) {
            throw new EmailAlreadyExistException("Email already exists");
        }

        User user = modelMapper.map(requestDTO, User.class);

        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO loginUser(LoginRequestDTO requestDTO) {

        User user = userRepo.findByEmail(requestDTO.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid Email or Password"));

        if (!passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid Email or Password");
        }

        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("User Not Found"));

        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO) {

        User existing = userRepo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("User Not Found"));

        if (!existing.getEmail().equals(requestDTO.getEmail())
                && userRepo.existsByEmail(requestDTO.getEmail())) {
            throw new EmailAlreadyExistException("Email already exists");
        }

        existing.setFullName(requestDTO.getFullName());
        existing.setEmail(requestDTO.getEmail());
        existing.setPhone(requestDTO.getPhone());
        existing.setRole(requestDTO.getRole());

        if (requestDTO.getPassword() != null && !requestDTO.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        }

        User updated = userRepo.save(existing);

        return modelMapper.map(updated, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("User Not Found"));

        userRepo.delete(user);
    }
}