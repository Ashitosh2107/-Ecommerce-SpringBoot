package com.example.Ecommerce.DTO.Role;

import com.example.Ecommerce.RoleName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponseDTO {

    private Long id;

    private RoleName name;

    private String description;
}