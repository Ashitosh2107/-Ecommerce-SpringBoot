package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.Exceptions.ProductNotFoundException;
import com.example.Ecommerce.Model.Admin;
import com.example.Ecommerce.Repository.AdminRepo;
import com.example.Ecommerce.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Admin Not Found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {

        Admin existing = adminRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Admin Not Found"));

        existing.setFullName(admin.getFullName());
        existing.setEmail(admin.getEmail());
        existing.setPhone(admin.getPhone());
        existing.setPassword(admin.getPassword());

        return adminRepo.save(existing);
    }

    @Override
    public void deleteAdmin(Long id) {

        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Admin Not Found"));

        adminRepo.delete(admin);
    }
}