package com.gupaoedu.example.controller;

import com.gupaoedu.example.dao.entity.User;
import com.gupaoedu.example.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class HelloController {

    @Autowired
    IUserService userService;

    @GetMapping("/test")
    public String test(){
        User user=new User();
        user.setName("Mic");
        userService.insert(user);
        return "Hello Spring Boot";
    }
}
