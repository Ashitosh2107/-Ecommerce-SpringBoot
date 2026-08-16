package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.DTO.Role.RoleRequestDTO;
import com.example.Ecommerce.DTO.Role.RoleResponseDTO;
import com.example.Ecommerce.Model.Role;
import com.example.Ecommerce.Repository.RoleRepo;
import com.example.Ecommerce.RoleName;
import com.example.Ecommerce.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    private final ModelMapper modelMapper;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO dto) {

        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());

        Role savedRole = roleRepo.save(role);

        return modelMapper.map(savedRole, RoleResponseDTO.class);
    }

    @Override
    public RoleResponseDTO getRole(Long id) {

        Role role = roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        return modelMapper.map(role, RoleResponseDTO.class);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {

        return roleRepo.findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO dto) {

        Role role = roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        role.setName(dto.getName());
        role.setDescription(dto.getDescription());

        Role updatedRole = roleRepo.save(role);

        return modelMapper.map(updatedRole, RoleResponseDTO.class);
    }

    @Override
    public void delete(Long id) {

        Role role = roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        roleRepo.delete(role);
    }
}