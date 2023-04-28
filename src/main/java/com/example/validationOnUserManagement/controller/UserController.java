package com.example.validationOnUserManagement.controller;

import com.example.validationOnUserManagement.service.UserService;
import com.example.validationOnUserManagement.service.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    //Get All Value....................
    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUserFromService();
    }

    // Add user...................
    @PostMapping(value = "addUser")
    public String addUserToService(@Valid @RequestBody User user){
        return userService.addUserToService(user);
    }

    //get user by userid

    @RequestMapping(value = "/getUserByUserId/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    // Delete user

    @DeleteMapping(value = "/deleteUserByUserId/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUserFromList(userId);
    }

    //Update user............................................

    @PutMapping(value = "/updateUser/{userId}/{status}")
    public String updateUser(@PathVariable String userId, @PathVariable String status){
        return userService.updateUser(userId, status);
    }

}
