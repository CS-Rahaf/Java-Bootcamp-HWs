package com.example.homework27.Service;


import com.example.homework27.Model.MyUser;
import com.example.homework27.Repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyUserService {

    private final MyUserRepository myUserRepository;


    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepository.save(myUser);
    }


}
