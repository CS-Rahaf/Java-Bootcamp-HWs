package com.example.project4.Repository;

import com.example.project4.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    Hospital findHospitalById(Integer id);

    @Query("select u from Hospital u where u.InsuranceCompanyID=?1")
    List<Hospital> findAllByInsuranceCompanyID(Integer id);

    Hospital findHospitalByName(String Name);
}
