package com.example.project5.Service;


import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Customer;
import com.example.project5.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;


    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }


    public Customer getCustomer(Integer id){
        Customer Customer = customerRepository.findCustomerById(id);
        if(Customer==null){
            throw new ApiException("Customer not found");
        }

        return Customer;
    }
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id, Customer customer){
        Customer currentCustomer = customerRepository.findCustomerById(id);
        if(currentCustomer==null){
            throw new ApiException("Customer not found");
        }

        customer.setId(currentCustomer.getId());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        Customer currentCustomer = customerRepository.findCustomerById(id);

        if(currentCustomer == null){
            throw new ApiException("Customer not found");
        }
        customerRepository.deleteById(id);
    }


}
