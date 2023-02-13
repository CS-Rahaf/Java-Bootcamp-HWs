package com.example.homework27.Controller;


import com.example.homework27.Model.MyUser;
import com.example.homework27.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final MyUserService myUserService;


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser){
        myUserService.register(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User has been registered");
    }


    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back");
    }

    @PostMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back ADMIN");
    }


}
