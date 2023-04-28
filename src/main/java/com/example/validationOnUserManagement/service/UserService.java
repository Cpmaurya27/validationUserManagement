package com.example.validationOnUserManagement.service;

import com.example.validationOnUserManagement.repository.UserDao;
import com.example.validationOnUserManagement.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    // Get User
    public List<User> getAllUserFromService(){
        return userDao.getAllUserFromRepository();
    }

    //Add User
    public String addUserToService(User user){
        boolean insertion = userDao.save(user);
        if(insertion){
            return "User added Successfully!!!!!";
        }
        else{
            return "Adding new user failed!!!!!.....";
        }
    }

    //get User by userId
    public User getUserByUserId(String userId){
        List<User> availableUser = userDao.getAllUserFromRepository();
        for(User user: availableUser){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    //Delete user from the list...........

    public String deleteUserFromList(String userId){
        boolean deleteResponse = false;
        String status;
        if(userId != null){
            List<User> availableUser = userDao.getAllUserFromRepository();
            for(User user : availableUser){
                if(user.getUserId().equals(userId)){
                    deleteResponse = userDao.remove(user);
                    if(deleteResponse){
                        status =  "User with " + userId + " deleted successfully!!!....";
                    }
                    else {
                        status = "User with " + userId + " deletion is not possible!";
                    }
                    return status;
                }
            }
            return "user with " + userId + " does not exist!..";
        }
        else{
            return "Invalid userId.... cannot be null userId";
        }
    }

    //update user.............
    public String updateUser(String userId, String status){
        boolean updateStatus = userDao.update(userId, status);
        if(updateStatus){
            return "user with " + userId+ " updated successfully!!!!!....";
        }
        else{
            return "user with " + userId + " update failed!";
        }
    }
}
