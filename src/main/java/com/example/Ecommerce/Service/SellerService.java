package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Seller;

import java.util.List;

public interface SellerService {

    Seller saveSeller(Seller seller);

    Seller getSellerById(Long id);

    List<Seller> getAllSellers();

    Seller updateSeller(Long id, Seller seller);

    void deleteSeller(Long id);
}