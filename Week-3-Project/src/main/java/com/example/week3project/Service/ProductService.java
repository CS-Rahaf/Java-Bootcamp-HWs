package com.example.week3project.Service;

import com.example.week3project.Model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();
    private final CategoryService categoryService;


    public ArrayList<Product> getProducts(){
        return products;
    }

    public Product getProduct(String id){
        for (Product product: products) {
            if(product.getId().equals(id))
                return product;
        }
        return null;
    }

    public int addProduct(Product product){
        if(isExist(product.getId())){
            return -1;
        }
        else if (!categoryService.isExist(product.getCategoryId())) {
            return 1;
        }
        else {
            products.add(product);
            return 0;
        }
    }
    public boolean updateProduct(String id, Product product){
        if(isExist(id)){
            for (Product productLoop: products) {
                if(productLoop.getId().equals(id)){
                    int index= products.indexOf(productLoop);
                    products.set(index,product);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteProduct(String id){
        if(isExist(id)){
            for (Product productLoop: products) {
                if(productLoop.getId().equals(id)){
                    int index= products.indexOf(productLoop);
                    products.remove(index);
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isExist(String id){
        for (Product product : products) {
            if(product.getId().equals(id))
                return true;
        }
        return false;
    }


}
