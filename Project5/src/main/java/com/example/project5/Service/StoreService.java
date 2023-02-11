package com.example.project5.Service;


import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.StoreRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public List<Store> getStores(){
        return storeRepository.findAll();
    }


    public Store getStore(Integer id){
        Store Store = storeRepository.findStoreById(id);
        if(Store==null){
            throw new ApiException("Store not found");
        }

        return Store;
    }
    public void addStore(Store store){
        storeRepository.save(store);
    }
    public void updateStore(Integer id, Store store){
        Store currentStore = storeRepository.findStoreById(id);
        if(currentStore==null){
            throw new ApiException("Store not found");
        }

        store.setId(currentStore.getId());
        storeRepository.save(store);
    }

    public void deleteStore(Integer id){
        Store currentStore = storeRepository.findStoreById(id);

        if(currentStore == null){
            throw new ApiException("Store not found");
        }
        storeRepository.deleteById(id);
    }

    public void assignCustomerToStore(ObjectNode objectNode){

        Integer storeId = objectNode.get("storeId").asInt();
        Store store= getStore(storeId);

        Integer customerId = objectNode.get("customerId").asInt();
        Customer customer = customerService.getCustomer(customerId);

        store.getCustomers().add(customer);
        storeRepository.save(store);

        customer.getStores().add(store);
        customerRepository.save(customer);
    }

    public List<Book> getBooks(Integer storeId){
        Store store = getStore(storeId);
        return store.getBooks();
    }

    public List<Customer> getCustomers(Integer storeId){
        Store store = getStore(storeId);
        return store.getCustomers();
    }



}
