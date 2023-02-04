package com.example.project4.Controller;

import com.example.project4.Model.InsuranceCompany;
import com.example.project4.Model.User;
import com.example.project4.Service.InsuranceCompanyService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/insuranceCompanies")
@AllArgsConstructor
public class InsuranceCompanyController {


    private final InsuranceCompanyService insuranceCompanyService;


    @GetMapping("")
    public ResponseEntity getInsuranceCompany(){
        List<InsuranceCompany> insuranceCompanies= insuranceCompanyService.getInsuranceCompanies();

        return ResponseEntity.status(200).body(insuranceCompanies);
    }


    @PostMapping("")
    public ResponseEntity addInsuranceCompany(@Valid @RequestBody InsuranceCompany InsuranceCompany){
        insuranceCompanyService.addInsuranceCompany(InsuranceCompany);
        return ResponseEntity.status(200).body("Insurance Company has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateInsuranceCompany(@PathVariable Integer id, @Valid @RequestBody InsuranceCompany InsuranceCompany){

        insuranceCompanyService.updateInsuranceCompany(id,InsuranceCompany);
        return ResponseEntity.status(200).body("Insurance Company has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteInsuranceCompany(@PathVariable Integer id){
        insuranceCompanyService.deleteInsuranceCompany(id);
        return ResponseEntity.status(200).body("Insurance Company has been deleted Successfully");
    }





}
