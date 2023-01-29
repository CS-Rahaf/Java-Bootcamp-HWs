package com.example.week3project.Controller;

import com.example.week3project.Model.Merchant;
import com.example.week3project.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
public class MerchantController {


    private final MerchantService merchantService;

    @GetMapping("")
    public ResponseEntity getMerchants(){
        ArrayList<Merchant> merchants= merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMerchant(@PathVariable String id){
        if(merchantService.getMerchant(id)!=null) {
            Merchant merchant = merchantService.getMerchant(id);
            return ResponseEntity.status(200).body(merchant);
        }

        return ResponseEntity.status(400).body("Merchant doesn't exist");
    }

    @PostMapping("")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(merchantService.addMerchant(merchant) == 0){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant is Added successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Merchant already exits"));
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateMerchant(@PathVariable String id, @Valid @RequestBody Merchant merchant, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(merchantService.updateMerchant(id,merchant)){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant is updated successfully"));
        }
        else {
            return ResponseEntity.status(400).body(new ApiResponse("Merchant does not exist"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){

        if(merchantService.deleteMerchant(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant is deleted successfully"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("Merchant does not exist"));
        }

    }
    
}
