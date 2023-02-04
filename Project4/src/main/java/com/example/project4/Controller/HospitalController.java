package com.example.project4.Controller;

import com.example.project4.Model.Hospital;
import com.example.project4.Service.HospitalsService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalController {

        private final HospitalsService hospitalService;


        @GetMapping("")
        public ResponseEntity getHospital(){
        List<Hospital> hospitals= hospitalService.getHospitales();

        return ResponseEntity.status(200).body(hospitals);
    }


        @PostMapping("")
        public ResponseEntity addHospital(@Valid @RequestBody Hospital hospital){
            hospitalService.addHospital(hospital);
        return ResponseEntity.status(200).body("Hospital has been added Successfully");
    }


        @PutMapping("/{id}")
        public ResponseEntity updateHospital(@PathVariable Integer id, @Valid @RequestBody Hospital hospital){

            hospitalService.updateHospital(id,hospital);
        return ResponseEntity.status(200).body("Hospital has been updated Successfully");
    }


        @DeleteMapping ("/{id}")
        public ResponseEntity deleteHospital(@PathVariable Integer id){
            hospitalService.deleteHospital(id);
        return ResponseEntity.status(200).body("Hospital has been deleted Successfully");
    }


    @GetMapping("/insuranceCompanies/{id}")
    public ResponseEntity hospitalsForInsuranceCompany(@PathVariable Integer id){
        List<Hospital> hospitals= hospitalService.getHospitalByInsuranceCompany(id);

        return ResponseEntity.status(200).body(hospitals);
    }


    }
