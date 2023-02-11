package com.example.project5.Controller;

import com.example.project5.Model.Customer;
import com.example.project5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/customers")
public class CustomerController {


    private final CustomerService customerService;


    @GetMapping("")
    public ResponseEntity getCustomers(){
        List<Customer> customers= customerService.getCustomers();

        return ResponseEntity.status(200).body(customers);
    }

    //First required endpoint
    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable Integer id){
        Customer customers= customerService.getCustomer(id);

        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer){

        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body("Customer has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer has been deleted Successfully");
    }
    
}
