package com.example.homework28.Controller;

import com.example.homework28.Model.MyUser;
import com.example.homework28.Model.Orderr;
import com.example.homework28.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/user")
    public ResponseEntity getUser(@AuthenticationPrincipal MyUser myUser){
        MyUser myUser1 = myUserService.getUser(myUser);
        return ResponseEntity.status(200).body(myUser1);
    }


}
