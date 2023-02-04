package com.example.project4.Controller;

import com.example.project4.Model.User;
import com.example.project4.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity getUser(){
        List<User> Users=userService.getUsers();
        return ResponseEntity.status(200).body(Users);
    }

    @PostMapping("")
    public ResponseEntity addUser(@Valid @RequestBody User User){
        userService.addUser(User);
        return ResponseEntity.status(200).body("User added");
    }
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("User updated");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        return ResponseEntity.status(200).body("User deleted");
    }




/*


    @GetMapping("/age/{age}")
    public ResponseEntity getUsersbyAge(@PathVariable int age) {
        List<User> ages = userService.ageGreaterThan(age);
        return ResponseEntity.status(200).body(ages);
    }

    @GetMapping("/ageAbove/{age}")
    public ResponseEntity getGoldsbyAge(@PathVariable int age) {
        double ages = userService.goldAboveAge(age);
        return ResponseEntity.status(200).body("Gold users percentage above 50 years : " + ages + " % ");
    }
*/


   /* @GetMapping("/usersHospital/{id}")
    public ResponseEntity getHospitalByInC(@PathVariable Integer id) {
        List<Hospital> hospitals= userService.getHospitalByCompany(id);
        return ResponseEntity.status(200).body(hospitals);
    }
*/

}
