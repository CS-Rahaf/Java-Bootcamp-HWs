package com.example.week3project.Service;

import com.example.week3project.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getUsers(){
        return users;
    }

    public User getUser(String id){
        for (User user: users) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public int addUser(User user){
        if(isExist(user.getId())){
            return -1;
        }
       else {
            users.add(user);
            return 0;
        }
    }

    public boolean updateUser(String id, User user) {
      if(isExist(id)){
          for (User userLoop: users) {
              if(userLoop.getId().equals(id)){
                  int index= users.indexOf(userLoop);
                  users.set(index,user);
                  return true;
              }
          }
      }
        return false;
    }

    public boolean deleteUser(String id){
        if(isExist(id)){
            for (User userLoop: users) {
                if(userLoop.getId().equals(id)){
                    int index= users.indexOf(userLoop);
                    users.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(String id){
        for (User user : users) {
            if(user.getId().equals(id))
                return true;
        }
        return false;
    }

}
