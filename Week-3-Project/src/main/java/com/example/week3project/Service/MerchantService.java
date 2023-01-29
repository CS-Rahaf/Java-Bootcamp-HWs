package com.example.week3project.Service;

import com.example.week3project.Model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();


    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public Merchant getMerchant(String id){
        for (Merchant merchant: merchants) {
            if(merchant.getId().equals(id))
                return merchant;
        }
        return null;
    }

    public int addMerchant(Merchant merchant){
        if(isExist(merchant.getId())){
            return -1;
        }
        else {
            merchants.add(merchant);
            return 0;
        }
    }

    public boolean updateMerchant(String id, Merchant merchant){
        if(isExist(id)){
            for (Merchant merchantLoop: merchants) {
                if(merchantLoop.getId().equals(id)){
                    int index= merchants.indexOf(merchantLoop);
                    merchants.set(index,merchant);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteMerchant(String id){
        if(isExist(id)){
            for (Merchant merchantLoop: merchants) {
                if(merchantLoop.getId().equals(id)){
                    int index= merchants.indexOf(merchantLoop);
                    merchants.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(String id){
        for (Merchant merchant : merchants) {
            if(merchant.getId().equals(id))
                return true;
        }
        return false;
    }

}
