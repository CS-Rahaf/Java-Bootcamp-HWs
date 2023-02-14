package com.example.homework28.Service;


import com.example.homework28.Exception.ApiException;
import com.example.homework28.Model.Product;
import com.example.homework28.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getProducts(){
        return productRepository.findAll();
    }


    public Product getProduct(Integer id){
        Product Product = productRepository.findProductById(id);
        if(Product==null){
            throw new ApiException("Product not found");
        }

        return Product;
    }
    public void addProduct(Product Product){
        productRepository.save(Product);
    }
    public void updateProduct(Integer id, Product Product){
        Product currentProduct = productRepository.findProductById(id);
        if(currentProduct==null){
            throw new ApiException("Product not found");
        }

        Product.setId(currentProduct.getId());
        productRepository.save(Product);
    }

    public void deleteProduct(Integer id){
        Product currentProduct = productRepository.findProductById(id);

        if(currentProduct == null){
            throw new ApiException("Product not found");
        }
        productRepository.deleteById(id);
    }


    

}
