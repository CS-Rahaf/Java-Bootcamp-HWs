package com.example.week3project.Controller;

import com.example.week3project.Model.Product;
import com.example.week3project.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity getProducts(){
        ArrayList<Product> products= productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable String id){
        if(productService.getProduct(id)!=null) {
            Product product = productService.getProduct(id);
            return ResponseEntity.status(200).body(product);
        }
        return ResponseEntity.status(400).body("Product doesn't exist");
    }
    @PostMapping("")
    public ResponseEntity addProduct(@Valid @RequestBody Product Product, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(productService.addProduct(Product)==0){
            return ResponseEntity.status(200).body(new ApiResponse("Product is Added successfully"));
        }
        else if(productService.addProduct(Product)==1){
            return ResponseEntity.status(400).body(new ApiResponse("Category does not exist"));
        }
       else
            return ResponseEntity.status(400).body(new ApiResponse("Product already exists"));
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateProduct(@PathVariable String id, @Valid @RequestBody Product product, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(productService.updateProduct(id,product)){
            return ResponseEntity.status(200).body(new ApiResponse("Product is updated successfully"));
        }
        else {
            return ResponseEntity.status(400).body(new ApiResponse("Product does not exist"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){

        if(productService.deleteProduct(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Product is deleted successfully"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("Product does not exist"));
        }

    }

}
