package com.user.userservice.services;

import com.user.userservice.enity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements  UserService{

    //fake user list (Actually should be taken from DB)
    List<User> list = List.of(
            new User(115L, "Shubham", "566443"),
            new User(116L, "Shivam", "6655656"),
            new User(117L, "Shyam", "44116516")
    );

    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
