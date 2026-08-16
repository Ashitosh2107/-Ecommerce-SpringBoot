package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Seller;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller saveSeller(@RequestBody Seller seller) {
        return sellerService.saveSeller(seller);
    }

    @GetMapping("/{id}")
    public Seller getSeller(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @PutMapping("/{id}")
    public Seller updateSeller(@PathVariable Long id,
                               @RequestBody Seller seller) {
        return sellerService.updateSeller(id, seller);
    }

    @DeleteMapping("/{id}")
    public String deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return "Seller Deleted Successfully";
    }
}