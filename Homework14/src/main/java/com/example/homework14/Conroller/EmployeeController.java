package com.example.homework14.Conroller;

import com.example.homework14.ApiResponse;
import com.example.homework14.Model.Employee;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("")
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    @GetMapping("/{index}")
    public Employee getEmployee(@PathVariable int index){
        return employees.get(index);
    }

    @PostMapping("")
    public ResponseEntity addEmployee( @Valid @RequestBody Employee employee, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee added successfully"));

    }

    @PutMapping("/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index, @Valid @RequestBody Employee employee, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee updated successfully"));
    }

    @DeleteMapping("/{index}")
    public ApiResponse deleteEmployee(@PathVariable int index){
        employees.remove(index);
        return new ApiResponse("Employee deleted");
    }

    @GetMapping("/leaveApplying/{index}")
    public ResponseEntity leaveApplying(@PathVariable int index, @RequestParam(value = "daysNumber") int leave){
            Employee e= employees.get(index);

            if (e.getOnLeave() == true) {
                return ResponseEntity.status(400).body(new ApiResponse("You are already on leave"));
            }
            else if(leave <= 0){
                return ResponseEntity.status(400).body(new ApiResponse("Please enter valid days number"));
            }

            else if (e.getAnnualLeave() <= 0 || leave > e.getAnnualLeave()) {
                return ResponseEntity.status(400).body(new ApiResponse("Sorry, you have no available days"));
            }

            else {
                e.setAnnualLeave(e.getAnnualLeave() - leave);
                e.setOnLeave(true);
                return ResponseEntity.status(400).body(new ApiResponse("You got it!"));
            }
    }


    }
