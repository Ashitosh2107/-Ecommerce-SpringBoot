package com.example.Ecommerce.Controller;

import com.example.Ecommerce.DTO.Auth.LoginRequestDTO;
import com.example.Ecommerce.DTO.User.UserRequestDTO;
import com.example.Ecommerce.DTO.User.UserResponseDTO;
import com.example.Ecommerce.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDTO saveUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        return userService.saveUser(requestDTO);
    }

    @PostMapping("/login")
    public UserResponseDTO loginUser(@Valid @RequestBody LoginRequestDTO requestDTO) {
        return userService.loginUser(requestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id,
                                      @Valid @RequestBody UserRequestDTO requestDTO) {
        return userService.updateUser(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}