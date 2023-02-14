package com.example.homework28.Service;


import com.example.homework28.Model.MyUser;
import com.example.homework28.Repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public void register(MyUser myUser) {
        myUser.setRole("CUSTOMER");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUserRepository.save(myUser);
    }

    public MyUser getUser(MyUser myUser){
        MyUser myUser1 = myUserRepository.findMyUsersById(myUser.getId());
        return myUser1;
    }


}
