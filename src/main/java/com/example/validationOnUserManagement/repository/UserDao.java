package com.example.validationOnUserManagement.repository;

import com.example.validationOnUserManagement.service.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDao {

    List<User> userList;
    public UserDao(){
        userList = new ArrayList<>();
        //userList.add(new User("01", "Cp maurya", "02255455486", "cpmaurya25@gmail.com", "12/07/1995", "26/04/2023", "04:30"));
    }
    //get all user
    public List<User> getAllUserFromRepository(){
        return userList;
    }
    // add all user

    public boolean save(User user){
        userList.add(user);
        return true;

    }

    public boolean remove(User user){
        userList.remove(user);
        return true;
    }

    public boolean update(String userId, String status){
        boolean updateStatus = false;
        for(User user: userList){
            if(user.getUserId().equals(userId)){
                userList.remove(user);
                user.setName(status);
                save(user);
                return true;
            }
        }
        return false;
    }
}
