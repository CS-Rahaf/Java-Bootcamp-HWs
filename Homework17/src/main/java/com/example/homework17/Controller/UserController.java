package com.example.homework17.Controller;


import com.example.homework17.Mode.User;
import com.example.homework17.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

private final UserService userService;


    @GetMapping("")
    public ResponseEntity getUser(){
        List<User> users= userService.getUsers();

        return ResponseEntity.status(200).body(users);
    }


    @PostMapping("")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }


        userService.addUser(user);
        return ResponseEntity.status(200).body("User has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        if(!userService.updateUser(id,user)){

            return ResponseEntity.status(400).body("This user does not exit");
        }

        return ResponseEntity.status(200).body("User has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        if(!userService.deleteUser(id)){

            return ResponseEntity.status(400).body("This user does not exit");
        }

        return ResponseEntity.status(200).body("User has been deleted Successfully");
    }





}
