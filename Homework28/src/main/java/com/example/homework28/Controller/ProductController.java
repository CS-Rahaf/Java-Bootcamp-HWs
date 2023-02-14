package com.example.homework28.Controller;


import com.example.homework28.Model.MyUser;
import com.example.homework28.Model.Product;
import com.example.homework28.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("")
    public ResponseEntity getProducts(){
        List<Product> products= productService.getProducts();

        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Integer id){
        Product Products= productService.getProduct(id);

        return ResponseEntity.status(200).body(Products);
    }

    @PostMapping("")
    public ResponseEntity addProduct( @Valid @RequestBody Product Product){
        productService.addProduct(Product);
        return ResponseEntity.status(200).body("Product has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateProduct( @PathVariable Integer id, @Valid @RequestBody Product Product){

        productService.updateProduct(id,Product);
        return ResponseEntity.status(200).body("Product has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("Product has been deleted Successfully");
    }



}
