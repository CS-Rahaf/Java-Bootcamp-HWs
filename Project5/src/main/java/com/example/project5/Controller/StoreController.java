package com.example.project5.Controller;


import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Service.StoreService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/stores")
public class StoreController {

    private final StoreService storeService;


    @GetMapping("")
    public ResponseEntity getStores(){
        List<Store> stores= storeService.getStores();

        return ResponseEntity.status(200).body(stores);
    }

    //First required endpoint
    @GetMapping("/{id}")
    public ResponseEntity getStore(@PathVariable Integer id){
        Store stores= storeService.getStore(id);

        return ResponseEntity.status(200).body(stores);
    }

    @PostMapping("")
    public ResponseEntity addStore(@Valid @RequestBody Store store){
        storeService.addStore(store);
        return ResponseEntity.status(200).body("Store has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id, @Valid @RequestBody Store store){

        storeService.updateStore(id,store);
        return ResponseEntity.status(200).body("Store has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id){
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body("Store has been deleted Successfully");
    }


    @PostMapping("/assign")
    public ResponseEntity assignCustomerToStore(@Valid @RequestBody ObjectNode objectNode){
        storeService.assignCustomerToStore(objectNode);
        return ResponseEntity.status(200).body("Customer has been assigned to store Successfully");
    }


    @GetMapping("/{storeId}/books")
    public ResponseEntity getBooks(@PathVariable Integer storeId){
        List<Book> books= storeService.getBooks(storeId);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/{storeId}/customers")
    public ResponseEntity getCustomers(@PathVariable Integer storeId){
        List<Customer> customers= storeService.getCustomers(storeId);
        return ResponseEntity.status(200).body(customers);
    }


    


}
