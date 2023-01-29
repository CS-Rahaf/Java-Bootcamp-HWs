package com.example.week3project.Controller;

import com.example.week3project.Model.MerchantStock;
import com.example.week3project.Service.MerchantStockService;
import com.example.week3project.Service.PurchaseService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStocks")
@RequiredArgsConstructor
public class MerchantStockController {


    private final MerchantStockService merchantStockService;
    private final PurchaseService purchaseService;

    @GetMapping("")
    public ResponseEntity getMerchantStocks(){
        ArrayList<MerchantStock> MerchantStocks= merchantStockService.getMerchantStocks();
        return ResponseEntity.status(200).body(MerchantStocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMerchantStock(@PathVariable String id){
        if (merchantStockService.getMerchantStockById(id) != null) {
            MerchantStock MerchantStock = merchantStockService.getMerchantStockById(id);
            return ResponseEntity.status(200).body(MerchantStock);
        }
        return ResponseEntity.status(400).body("Merchant Stock doesn't exist");
    }

    @PostMapping("")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(merchantStockService.addMerchantStock(merchantStock) == 0) {
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock is Added successfully"));
        }
        else if(merchantStockService.addMerchantStock(merchantStock) == -1)
            return ResponseEntity.status(400).body(new ApiResponse("Merchant stock already exists"));

        else
            return ResponseEntity.status(400).body(new ApiResponse("Please check the product and merchant ids"));

        }

    @PutMapping("/{id}")
    public ResponseEntity UpdateMerchantStock(@PathVariable String id, @Valid @RequestBody MerchantStock merchantStock, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(merchantStockService.updateMerchantStock(id,merchantStock)){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock is updated successfully"));
        }
        else {
            return ResponseEntity.status(400).body(new ApiResponse("MerchantStock does not exist"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){

        if(merchantStockService.deleteMerchantStock(id)){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock is deleted successfully"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("MerchantStock does not exist"));
        }
    }


    @PostMapping("/purchase")
    @ResponseBody
    public ResponseEntity purchase(@RequestBody ObjectNode objectNode){
        String userId = objectNode.get("userId").asText();
        String productId = objectNode.get("productId").asText();
        String merchantId = objectNode.get("merchantId").asText();
        int purchaseResult= purchaseService.purchase(userId,productId,merchantId);

        if(purchaseResult == -1){
            return ResponseEntity.status(400).body(new ApiResponse("Please check the ids"));
        }
        else if(purchaseResult == 1){
            return ResponseEntity.status(400).body(new ApiResponse("The merchant doesn't have this product"));
        }
        else if(purchaseResult == 2){
            return ResponseEntity.status(400).body(new ApiResponse("User balance is less than the product price"));
        }
        else{
            return ResponseEntity.status(200).body(new ApiResponse("The purchase is done successfully"));
        }

    }

}
