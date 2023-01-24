package com.example.homework13.Controller;

import com.example.homework13.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    @GetMapping("/{index}")
    public Customer getCustomer(@PathVariable int index){

        return customers.get(index);
    }

    @PostMapping("")
    public String addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return "Customer has been added successfully";
    }

    @PutMapping("/{index}")
    public Customer updateCustomer(@PathVariable int index, @RequestBody Customer customer){
        customers.set(index, customer);
        return customers.get(index);
    }

    @DeleteMapping("/{index}")
    public String deleteTask(@PathVariable int index){
        customers.remove(index);
        return "Customer has been deleted successfully";
    }

    @GetMapping("/deposit/{index}")
    public Customer depositMoney(@PathVariable int index, @RequestParam(value = "amount") double amount){
        Customer customer = customers.get(index);
        double balance= customer.getBalance() + amount;
        customer.setBalance(balance);

        return customer;
    }

    @GetMapping("/withdraw/{index}")
    public Customer withdrawMoney(@PathVariable int index, @RequestParam(value = "amount") double amount){
        Customer customer = customers.get(index);
        double balance= customer.getBalance() - amount;
        customer.setBalance(balance);

        return customer;
    }




}
