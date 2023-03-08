package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    // User Operations

    //Create
    User createUser(User user);

    //Get All
    List<User> getAllUser();

    //Get
    User getUserById(String userId);

//    //Update
//    User updateUser(User user, String userId);
//
//    //Delete
//    void deleteUser(String userId);
}
