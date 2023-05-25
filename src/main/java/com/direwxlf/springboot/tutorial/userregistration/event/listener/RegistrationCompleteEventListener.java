package com.direwxlf.springboot.tutorial.userregistration.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;
import com.direwxlf.springboot.tutorial.userregistration.event.RegistrationCompleteEvent;
import com.direwxlf.springboot.tutorial.userregistration.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        // Create the verification token for the user with link.
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user, token);
        
        // Send Mail to User
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        //sendVerificationUrl();
        log.info("Click the link to verify your account: {}", url);
    }

}
