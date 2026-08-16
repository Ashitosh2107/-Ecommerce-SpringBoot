package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.User.UserRequestDTO;
import com.example.Ecommerce.DTO.User.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO saveUser(UserRequestDTO requestDTO);

    UserResponseDTO loginUser(LoginRequestDTO requestDTO);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO);

    void deleteUser(Long id);
}