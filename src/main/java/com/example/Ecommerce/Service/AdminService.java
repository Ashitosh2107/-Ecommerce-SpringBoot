package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Admin;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    Admin getAdminById(Long id);

    List<Admin> getAllAdmins();

    Admin updateAdmin(Long id, Admin admin);

    void deleteAdmin(Long id);
}