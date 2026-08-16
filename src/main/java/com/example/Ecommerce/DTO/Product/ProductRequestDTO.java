package com.example.Ecommerce.DTO.Product;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductRequestDTO {
    private String proname;
    private String Description;
    private Double price;
    private Integer stock;
    private String Brand;
    private String category;
    private String imageurl;


}
