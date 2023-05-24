package com.direwxlf.springboot.tutorial.userregistration.service;

import java.util.Optional;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;
import com.direwxlf.springboot.tutorial.userregistration.entity.VerificationToken;
import com.direwxlf.springboot.tutorial.userregistration.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(User user, String token);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);
    
}
