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
    public ResponseEntity addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body("User has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user){

        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("User has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User has been deleted Successfully");
    }

    @GetMapping("/roles")
    public ResponseEntity getAllUsersByRole(@RequestParam(value = "value") String role){
        List<User> users = userService.findUserByRole(role);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/emails")
    public ResponseEntity getAllUsersByEmail(@RequestParam(value = "value") String email){

        return ResponseEntity.status(200).body(userService.findUserByEmail(email));
    }

    @GetMapping("/")
    public ResponseEntity findUserByUsernameAndPass(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
       User user = userService.usernameAndPassMatching(username,password);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/age")
    public ResponseEntity findUsersGreaterThanAge(@RequestParam(value = "value") int age){
        List<User> users = userService.findUserByAge(age);
        return ResponseEntity.status(200).body(users);
    }




}
