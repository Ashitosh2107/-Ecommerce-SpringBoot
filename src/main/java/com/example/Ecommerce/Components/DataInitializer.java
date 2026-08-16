package com.example.Ecommerce.Components;

import com.example.Ecommerce.Model.Role;
import com.example.Ecommerce.Repository.RoleRepo;
import com.example.Ecommerce.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepo roleRepository;

    @Override
    public void run(String... args) {

        createRoleIfNotExists(RoleName.ADMIN, "System Administrator");
        createRoleIfNotExists(RoleName.SELLER, "Product Seller");
        createRoleIfNotExists(RoleName.CUSTOMER, "Customer");
    }

    private void createRoleIfNotExists(RoleName name, String description) {

        if (!roleRepository.existsByName(name)) {

            Role role = Role.builder()
                    .name(name)
                    .description(description)
                    .build();

            roleRepository.save(role);
        }
    }
}