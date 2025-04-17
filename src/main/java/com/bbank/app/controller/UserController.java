package com.bbank.app.controller;


import com.bbank.app.model.LoginUser;
import com.bbank.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);


    @PostMapping("/registerUser")
    public String registerUser(@RequestBody LoginUser user) throws Exception {
        LoginUser existingUser = userService.getUserByUserName(user.getUserName());
        if(null!=existingUser) {
            throw new Exception("User already exists");
        } else {
            String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            userService.saveUser(user);
        }

        return "User Registered";
    }
}
