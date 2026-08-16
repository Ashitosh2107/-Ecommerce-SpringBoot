package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.Role.RoleRequestDTO;
import com.example.Ecommerce.DTO.Role.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    RoleResponseDTO createRole (RoleRequestDTO dto);
    RoleResponseDTO getRole (Long id);
    List<RoleResponseDTO> getAllRoles();
    RoleResponseDTO updateRole (Long id,RoleRequestDTO dto);
    void delete (Long id);
}
