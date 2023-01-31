package com.example.homework17.Service;


import com.example.homework17.Exception.ApiException;
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

    //Old update method that return false when user does not exist and handling done in controller
 /*   public boolean updateUser(Integer id, User user){
        boolean checker = userRepository.existsById(id);

        if(checker){
            User oldUser= userRepository.getById(id);
            user.setId(oldUser.getId());
            userRepository.save(user);
            return true;
        }
        return false;
    }*/

    //new update method that throw exception when user does not exist and handling done in Advise controller
    public void updateUser(Integer id, User user){
        User currentuser = userRepository.findUserById(id);
        if(currentuser==null){
            throw new ApiException("User not found");
        }

        user.setId(currentuser.getId());
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User currentuser = userRepository.findUserById(id);

        if(currentuser == null){
            throw new ApiException("User not found");
        }
        userRepository.deleteById(id);
    }

    public List<User>findUserByRole(String role){
        return userRepository.findUserByRole(role);
    }

    public User usernameAndPassMatching(String username,String password){
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user == null){
            throw new ApiException("This user not exist");
        }
        return user;
    }

    public User findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new ApiException("This user not exist");
        }
        return user;
    }

    public List<User> findUserByAge(int age){
        return userRepository.findUserByAge(age);
    }


}
