package com.user.userservice.controller;

import com.user.userservice.enity.User;
import com.user.userservice.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // this rest template bean is used in UserController
    // to interact with contact Service to get all the contacts of
    // current userId

    // this bean is defined in UserserviceApplication.java
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        User user = userService.getUser(userId);
        // http://localhost:9002/contact/user/116
        // fetching contactList of current userId from contact service
        // List contacts = restTemplate.getForObject("http://localhost:9002/contact/user/"+userId, List.class);
        // commented the above line as we were dependent on localhost as written in URL
        // now we are using Eureka client, so can directly use contact-service client registered with Eureka server
        List contacts = restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);
        // setting the above contactList which we got from a different service (contact service) to the user object of this service
        user.setContactList(contacts);
        return user;
    }
}
