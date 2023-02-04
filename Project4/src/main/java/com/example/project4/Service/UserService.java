package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.User;
import com.example.project4.Repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class UserService {


    private final UserRepositry userRepositry;
    private final HospitalsService hospitalsService;

    public List<User> getUsers(){
        return userRepositry.findAll();
    }

    public User getUser(Integer id){
        User user = userRepositry.findUserById(id);
        if(user==null){
            throw new ApiException("User not found");
        }
        return user;
    }

    public void addUser(User user){
        userRepositry.save(user);
    }

    public void updateUser(Integer id, User user){
        User currentuser = userRepositry.findUserById(id);
        if(currentuser==null){
            throw new ApiException("User not found");
        }

        user.setId(currentuser.getId());
        userRepositry.save(user);

    }

    public void deleteUser(Integer id) {
        User currentUser = userRepositry.findUserById(id);

        if(currentUser == null){
            throw new ApiException("Insurance Company not found");
        }
        userRepositry.deleteById(id);
    }


    public List<User> usersByCategory(String category){
        List<User> users= userRepositry.findAllByInsuranceCategory(category);
        return users;
    }






/*   public List<Hospital> getHospitalByCompany(Integer userrId){
        int insuranceCompanyId= userRepositry.finduserrById(userrId).getInsuranseID();
        List<Hospital> hospitals= hospitalsService.getHospitalByInsuranceCompany(insuranceCompanyId);
        return hospitals;

    }*/



}
