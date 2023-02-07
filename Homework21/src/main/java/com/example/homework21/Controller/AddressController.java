package com.example.homework21.Controller;


import com.example.homework21.Model.Address;
import com.example.homework21.Service.AddressService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/addresses")
public class AddressController {

    private final AddressService addressService;


    @GetMapping("")
    public ResponseEntity getAddress(){
        List<Address> Address= addressService.getAddresses();

        return ResponseEntity.status(200).body(Address);
    }


    @PostMapping("")
    @ResponseBody
    public ResponseEntity addAddress(@Valid @RequestBody ObjectNode objectNode){
        addressService.addAddress(objectNode);
        return ResponseEntity.status(200).body("Address has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @Valid @RequestBody Address address){

        addressService.updateAddress(id,address);
        return ResponseEntity.status(200).body("Address has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address has been deleted Successfully");
    }

}
