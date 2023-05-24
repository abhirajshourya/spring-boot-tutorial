package com.direwxlf.springboot.tutorial.userregistration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;
import com.direwxlf.springboot.tutorial.userregistration.entity.VerificationToken;
import com.direwxlf.springboot.tutorial.userregistration.event.RegistrationCompleteEvent;
import com.direwxlf.springboot.tutorial.userregistration.model.UserModel;
import com.direwxlf.springboot.tutorial.userregistration.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Success!";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "User Successfully Verified!";
        }
        return "Bad User!";
    }

    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest request) {
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
        User user = verificationToken.getUser();
        resendVerificationTokenMail(user, applicationUrl(request), verificationToken.getToken());
        return "Verification Link Sent!";
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, String verificationToken) {
        // Send Mail to User
        String url = applicationUrl + "/verifyRegistration?token=" + verificationToken;

        // sendVerificationUrl();
        log.info("Click the link to verify your account: {}", url);
    }
}
