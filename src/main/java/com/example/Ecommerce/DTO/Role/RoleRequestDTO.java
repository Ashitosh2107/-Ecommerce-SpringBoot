package com.example.Ecommerce.DTO.Role;

import com.example.Ecommerce.RoleName;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleRequestDTO {

    @NotNull(message = "Role name is required")
    private RoleName name;

    private String description;
}