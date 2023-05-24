package com.direwxlf.springboot.tutorial.userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;
import com.direwxlf.springboot.tutorial.userregistration.entity.VerificationToken;
import com.direwxlf.springboot.tutorial.userregistration.model.UserModel;
import com.direwxlf.springboot.tutorial.userregistration.repository.UserRepository;
import com.direwxlf.springboot.tutorial.userregistration.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

}
