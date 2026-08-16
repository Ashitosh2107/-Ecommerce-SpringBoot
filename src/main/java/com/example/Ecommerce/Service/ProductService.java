package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.Product.ProductRequestDTO;
import com.example.Ecommerce.DTO.Product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO save (ProductRequestDTO dto);
    ProductResponseDTO getById(Long id);
    List<ProductResponseDTO> getAll();
    ProductResponseDTO update(Long id,ProductRequestDTO dto);
    void delete (Long id);
}
