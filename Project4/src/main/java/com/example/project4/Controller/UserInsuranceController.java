package com.example.project4.Controller;


import com.example.project4.Model.User;
import com.example.project4.Service.InsuranceCompanyService;
import com.example.project4.Service.UserInsuranceService;
import com.example.project4.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserInsuranceController {

    private final UserService userService;
    private final InsuranceCompanyService insuranceCompanyService;
    private final UserInsuranceService userInsuranceService;

    @PostMapping("/insurance/buy")
    @ResponseBody
    public ResponseEntity buyInsurance(@RequestBody ObjectNode objectNode){
        Integer userId = objectNode.get("userId").asInt();
        Integer insuranceCompanyId = objectNode.get("insuranceCompanyId").asInt();
        String insuranceCategory = objectNode.get("insuranceCategory").asText();

        userInsuranceService.buyInsurance(userId, insuranceCompanyId, insuranceCategory);

        return ResponseEntity.status(200).body("You have bought the insurance successfully");
    }

    @GetMapping("/insurance/status/{id}")
    public ResponseEntity getInsuranceStatus(@PathVariable Integer id){
        String status= userInsuranceService.getUserInsuranceStatus(id);
        return ResponseEntity.status(200).body(status);
    }

    @GetMapping("/insuranceCompanies/{id}/category/{category}/users")
    public ResponseEntity getUsersByCategory(@PathVariable Integer id, @PathVariable String category) {
        List<User> users = userInsuranceService.usersPerCategory(id, category);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/insuranceCompanies/{id}/category/{category}/users/statistics")
    public ResponseEntity statistics(@PathVariable Integer id, @PathVariable String category) {
        double statistics = userInsuranceService.statistics(id, category);
        return ResponseEntity.status(200).body(statistics);
    }








}
