package com.example.Ecommerce.ServiceImpl;

import com.example.Ecommerce.DTO.Product.ProductRequestDTO;
import com.example.Ecommerce.DTO.Product.ProductResponseDTO;
import com.example.Ecommerce.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponseDTO save(ProductRequestDTO dto) {
        return null;
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
