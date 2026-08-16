package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.Exceptions.ProductNotFoundException;
import com.example.Ecommerce.Model.Seller;
import com.example.Ecommerce.Repository.SellerRepo;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepo sellerRepo;

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepo.save(seller);
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Seller Not Found"));
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) {

        Seller existing = sellerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Seller Not Found"));

        existing.setFullName(seller.getFullName());
        existing.setEmail(seller.getEmail());
        existing.setPhone(seller.getPhone());
        existing.setPassword(seller.getPassword());
        existing.setRole(seller.getRole());

        return sellerRepo.save(existing);
    }

    @Override
    public void deleteSeller(Long id) {

        Seller seller = sellerRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Seller Not Found"));

        sellerRepo.delete(seller);
    }
}