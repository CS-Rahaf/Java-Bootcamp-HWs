package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.InsuranceCompany;
import com.example.project4.Model.User;
import com.example.project4.Repository.InsuranceCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InsuranceCompanyService {

    private final InsuranceCompanyRepository insuranceCompanyRepository;
    private final UserService userService;

    public List<InsuranceCompany> getInsuranceCompanies(){
        return insuranceCompanyRepository.findAll();
    }


    public InsuranceCompany getInsuranceCompany(Integer id){
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findInsuranceCompanyById(id);
        if(insuranceCompany==null){
            throw new ApiException("Insurance Company not found");
        }

        return insuranceCompany;
    }
    public void addInsuranceCompany(InsuranceCompany InsuranceCompany){
        insuranceCompanyRepository.save(InsuranceCompany);
    }
    public void updateInsuranceCompany(Integer id, InsuranceCompany InsuranceCompany){
        InsuranceCompany currentInsuranceCompany = insuranceCompanyRepository.findInsuranceCompanyById(id);
        if(currentInsuranceCompany==null){
            throw new ApiException("Insurance Company not found");
        }

        InsuranceCompany.setId(currentInsuranceCompany.getId());
        insuranceCompanyRepository.save(InsuranceCompany);
    }

    public void deleteInsuranceCompany(Integer id){
        InsuranceCompany currentInsuranceCompany = insuranceCompanyRepository.findInsuranceCompanyById(id);

        if(currentInsuranceCompany == null){
            throw new ApiException("Insurance Company not found");
        }
        insuranceCompanyRepository.deleteById(id);
    }

    /*public List<User> usersPerCategory(Integer id , String category){
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findInsuranceCompanyById(id);
        if(insuranceCompany == null){
            throw new ApiException("Insurance Company not found");
        }

        List<User> users = userService.usersByCategory(category);
        List<User> companyUsers = new ArrayList<>();
        for (User user: users) {
            if(user.getInsuranceCompanyID().equals(id)){
                companyUsers.add(user);
            }
        }
        return companyUsers;

        }*/

    }


