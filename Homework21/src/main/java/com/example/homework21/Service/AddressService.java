package com.example.homework21.Service;


import com.example.homework21.Exception.ApiException;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.AddressRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    
    private final AddressRepository addressRepository;
    private final TeacherService teacherService;


    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }


    public Address getAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("Teacher not found");
        }

        return address;
    }
    public void addAddress(ObjectNode objectNode){
        Integer teacherId = objectNode.get("userId").asInt();
        Teacher teacher= teacherService.getTeacher(teacherId);

        String area = objectNode.get("area").asText();
        String street = objectNode.get("street").asText();
        Integer buildingNumber = objectNode.get("buildingNumber").asInt();

        Address address = new Address(null,area,street,buildingNumber,teacher);
        addressRepository.save(address);
    }
    public void updateAddress(Integer id, Address address){
        Address currentAddress = addressRepository.findAddressById(id);
        if(currentAddress==null){
            throw new ApiException("Address not found");
        }

        address.setId(currentAddress.getId());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address currentAddress = addressRepository.findAddressById(id);

        if(currentAddress == null){
            throw new ApiException("Address not found");
        }
        addressRepository.deleteById(id);
    }

}
