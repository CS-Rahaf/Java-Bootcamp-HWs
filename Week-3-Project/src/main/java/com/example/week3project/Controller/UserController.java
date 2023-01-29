package com.example.week3project.Controller;
import com.example.week3project.Model.User;
import com.example.week3project.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity getUsers(){
        ArrayList<User> users= userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        if(userService.getUser(id)!=null){
            User user = userService.getUser(id);
            return ResponseEntity.status(200).body(user);
        }
        else
            return ResponseEntity.status(400).body("User doesn't exist");

    }

    @PostMapping("")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(userService.addUser(user) == 0){
            return ResponseEntity.status(200).body(new ApiResponse("User is Added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User already exists"));
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateUser(@PathVariable String id, @Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(userService.updateUser(id,user)){
            return ResponseEntity.status(200).body(new ApiResponse("User is updated successfully"));
        }
        else {
            return ResponseEntity.status(400).body(new ApiResponse("User does not exist"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){

        if(userService.deleteUser(id)){
            return ResponseEntity.status(200).body(new ApiResponse("User is deleted successfully"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("User does not exist"));
        }
    }





}
