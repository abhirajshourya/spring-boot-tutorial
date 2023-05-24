package com.direwxlf.springboot.tutorial.userregistration.event;

import org.springframework.context.ApplicationEvent;

import com.direwxlf.springboot.tutorial.userregistration.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{

    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
