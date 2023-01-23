package com.example.homework12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    public WelcomeController() {
    }


    @GetMapping("/name")
    public String getName(){
        return "My name is Rahaf";
    }
    @GetMapping("/age")
    public String getAge(){
        return "My age is 25";
    }

    @GetMapping("/check/status")
    public String check(){
        return "Everything is OK";
    }

    @GetMapping("/helth")
    public String checkHelth(){
        return "Server health is up and running";
    }

}
