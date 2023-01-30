package com.example.homework17.Service;


import com.example.homework17.Mode.User;
import com.example.homework17.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user){
        boolean checker = userRepository.existsById(id);

        if(checker){
            User oldUser= userRepository.getById(id);
            user.setId(oldUser.getId());
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean deleteUser(Integer id){
        boolean checker = userRepository.existsById(id);

        if(checker){
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }


}
