package com.example.Ecommerce.DTO.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDTO {
    private Long id;
    private String proname;
    private String Description;
    private Double price;
    private Integer stock;
    private String Brand;
    private String category;
    private String imageurl;

}
