package com.direwxlf.springboot.tutorial.userregistration.service;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;
import com.direwxlf.springboot.tutorial.userregistration.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(User user, String token);
    
}
