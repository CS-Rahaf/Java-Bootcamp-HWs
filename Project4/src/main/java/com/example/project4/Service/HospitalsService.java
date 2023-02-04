package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.Hospital;
import com.example.project4.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalsService {

    private final HospitalRepository hospitalRepository;


    public List<Hospital> getHospitales(){

        return hospitalRepository.findAll();
    }


    public Hospital getHospital(Integer id){
        Hospital hospital = hospitalRepository.findHospitalById(id);
        if(hospital==null){
            throw new ApiException("Insurance class not found");
        }

        return hospital;
    }
    public void addHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }
    public void updateHospital(Integer id, Hospital hospital){
        Hospital currentHospital = hospitalRepository.findHospitalById(id);
        if(currentHospital==null){
            throw new ApiException("Insurance Class not found");
        }

        hospital.setId(currentHospital.getId());
        hospitalRepository.save(hospital);
    }

    public void deleteHospital(Integer id){
        Hospital currentHospital = hospitalRepository.findHospitalById(id);

        if(currentHospital == null){
            throw new ApiException("Insurance Class not found");
        }
        hospitalRepository.deleteById(id);
    }

    public List<Hospital> getHospitalByInsuranceCompany(Integer id){
        List<Hospital> hospitals = hospitalRepository.findAllByInsuranceCompanyID(id);

        return hospitals;
    }




}
