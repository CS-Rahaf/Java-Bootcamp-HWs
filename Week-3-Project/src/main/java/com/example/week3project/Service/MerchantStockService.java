package com.example.week3project.Service;

import com.example.week3project.Model.Merchant;
import com.example.week3project.Model.MerchantStock;
import com.example.week3project.Model.Product;
import com.example.week3project.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    private final ProductService productService;
    private final MerchantService merchantService;


    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }

    public MerchantStock getMerchantStockById(String id){
        for (MerchantStock merchantStock: merchantStocks) {
            if(merchantStock.getId().equals(id))
                return merchantStock;
        }
        return null;
    }

    public boolean updateMerchantStock(String id, MerchantStock merchantStock){
        if(getMerchantStockById(id) != null){
            for (MerchantStock merchantStockLoop: merchantStocks) {
                if(merchantStockLoop.getId().equals(id)){
                    int index= merchantStocks.indexOf(merchantStockLoop);
                    merchantStocks.set(index,merchantStock);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(String id){
        if(getMerchantStockById(id) != null){
            for (MerchantStock merchantStockLoop: merchantStocks) {
                if(merchantStockLoop.getId().equals(id)){
                    int index= merchantStocks.indexOf(merchantStockLoop);
                    merchantStocks.remove(index);
                    return true;
                }
            }
        }
        return false;

    }


   /* public boolean addMerchantStock(MerchantStock merchantStock){

        if(productService.isExist(merchantStock.getProductId())
                && merchantService.isExist(merchantStock.getMerchantId()))
        {
            merchantStocks.add(merchantStock);
            return true;
        }
        return false;
    }*/

    public int addMerchantStock(MerchantStock merchantStock){
        if(isExist(merchantStock.getProductId(),merchantStock.getMerchantId())){
            return -1;
        }

        if(productService.isExist(merchantStock.getProductId())
                && merchantService.isExist(merchantStock.getMerchantId()))
        {
            merchantStocks.add(merchantStock);
            return 0;
        }
        else
        return 1;
    }


    public boolean isExist(String productId, String merchantId){
        for (MerchantStock merchantStock : merchantStocks) {
           if(merchantStock.getMerchantId().equals(merchantId)
           && merchantStock.getProductId().equals(productId))
               return true;
        }
        return false;
    }

    public MerchantStock getMerchantStock(String productId, String merchantId){
        for (MerchantStock merchantStock : merchantStocks) {
            if(merchantStock.getMerchantId().equals(merchantId)
                    && merchantStock.getProductId().equals(productId))
                return merchantStock;
        }
        return null;
    }


}
