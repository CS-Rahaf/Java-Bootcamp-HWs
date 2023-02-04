package com.example.project4.Service;

import com.example.project4.Exception.ApiException;
import com.example.project4.Model.InsuranceCompany;
import com.example.project4.Model.User;
import com.example.project4.Repository.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserInsuranceService {

    private final UserService userService;
    private final InsuranceCompanyService insuranceCompanyService;
    private final UserRepositry userRepositry;


    //Rahaf
    public void buyInsurance(Integer userId, Integer insuranceCompanyId, String category) {
        User user = userService.getUser(userId);

        if (user.getInsuranceStatus() != null) {
            if (user.getInsuranceStatus().equals("Valid"))
                throw new ApiException("You already have a valid insurance");
        }

        //to check if we have this insurance company or not
        insuranceCompanyService.getInsuranceCompany(insuranceCompanyId);

        if(category.equals("VIP") || category.equals("Gold") || category.equals("Silver") || category.equals("Basic")){
            user.setInsuranceCompanyID(insuranceCompanyId);
            user.setInsuranceCategory(category);
            user.setStartDate(LocalDate.now());
            user.setInsuranceStatus("Valid");
            userRepositry.save(user);
        }
        else {
            throw new ApiException("The insurance category should be either VIP, Gold, Silver or Basic");
        }



    }

   //Rahaf
    public Long getRemainingDays(Integer userId) {
        User user = userService.getUser(userId);
        LocalDate endDate = user.getStartDate().plusYears(1);
        /*  Long remainingDays= Duration.between(endDate , LocalDate.now()).toDays();*/
        long result = ChronoUnit.DAYS.between(LocalDate.now(), endDate);
        return result;

    }

    //Rahaf
    public String getUserInsuranceStatus(Integer userId) {
        User user = userService.getUser(userId);

        if (user.getInsuranceCompanyID() == null) {
            throw new ApiException("There is no register insurance for this user");
        }

        Long remainingDays = getRemainingDays(userId);
        if (remainingDays < 0) {
            user.setInsuranceStatus("Not Valid");
            userRepositry.save(user);
            String status = "The insurance is not valid";
            return status;
        }

        String status = "The insurance is valid and the remaining days is: " + remainingDays.toString() + " days";
        return status;

    }

    //Shaima, Jamelah, Rahaf
    public List<User> usersPerCategory(Integer id, String category) {
        InsuranceCompany insuranceCompany = insuranceCompanyService.getInsuranceCompany(id);

        List<User> users = userService.usersByCategory(category);
        List<User> companyUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getInsuranceCompanyID().equals(id)) {
                companyUsers.add(user);
            }
        }
        return companyUsers;
    }


    //Shaima, Jamelah, Rahaf
    public double statistics(Integer id, String category) {

        List<User> VIPUsers = usersPerCategory(id, "VIP");
        List<User> goldUsers = usersPerCategory(id, "Gold");
        List<User> silverUsers = usersPerCategory(id, "Silver");
        List<User> basicUsers = usersPerCategory(id, "Basic");

        List<User> requiredCategory = usersPerCategory(id, category);

        double sum = VIPUsers.size() + goldUsers.size() + silverUsers.size() + basicUsers.size();
        double percentage = (requiredCategory.size() / sum) * 100;
        return percentage;
    }





}
