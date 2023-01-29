package com.example.week3project.Service;

import com.example.week3project.Model.MerchantStock;
import com.example.week3project.Model.Product;
import com.example.week3project.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseService {
    private final UserService userService;
    private final ProductService productService;
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;

    public int purchase(String userId, String productId, String merchantId){
        if(!userService.isExist(userId)
                || !productService.isExist(productId)
                || !merchantService.isExist(merchantId) ){
            return -1; // Wrong ids
        }
        else if (merchantStockService.isExist(productId,merchantId) == false){
            return 1; //No exist merchant stock
        }
       else if(!checkUserBalance(userService.getUser(userId),productId)){
            return 2; //User balance less than the product price
        }
        else {
            MerchantStock merchantStock = merchantStockService.getMerchantStock(productId,merchantId);
            checkout(userService.getUser(userId),merchantStock);
            return 0;
        }
    }

    public boolean checkUserBalance(User user, String productId){
        if (user.getBalance() >= productService.getProduct(productId).getPrice()){
            return true;
        }
        return false;
    }

    public void checkout(User user, MerchantStock merchantStock){
        merchantStock.setStock(merchantStock.getStock()-1);
        double userBalance = user.getBalance()- productService.getProduct(merchantStock.getProductId()).getPrice();
        user.setBalance(userBalance);
    }


}
