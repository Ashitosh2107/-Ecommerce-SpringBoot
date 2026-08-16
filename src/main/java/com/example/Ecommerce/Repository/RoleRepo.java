package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Role;
import com.example.Ecommerce.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);

    boolean existsByName(RoleName name);
}