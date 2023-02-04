package com.example.project4.Repository;

import com.example.project4.Model.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer> {

    public InsuranceCompany findInsuranceCompanyById(Integer id);
    public InsuranceCompany findInsuranceCompanyByName(String name);

}
