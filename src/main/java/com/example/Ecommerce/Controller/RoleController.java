package com.example.Ecommerce.Controller;

import com.example.Ecommerce.DTO.Role.RoleRequestDTO;
import com.example.Ecommerce.DTO.Role.RoleResponseDTO;
import com.example.Ecommerce.Service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public RoleResponseDTO createRole(@Valid @RequestBody RoleRequestDTO dto) {
        return roleService.createRole(dto);
    }

    @GetMapping("/{id}")
    public RoleResponseDTO getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @GetMapping
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/{id}")
    public RoleResponseDTO updateRole(@PathVariable Long id,
                                      @Valid @RequestBody RoleRequestDTO dto) {
        return roleService.updateRole(id, dto);
    }
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return "Role deleted successfully.";
    }
}