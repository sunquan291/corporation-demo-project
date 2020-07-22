package com.zte.sunquan.demo.contorl;

import com.zte.sunquan.demo.bean.User;
import com.zte.sunquan.demo.service.LoginService;
import com.zte.sunquan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Livio
 * @Date: 2020/7/17 22:49
 */
@RestController
public class HelloControl {

    @Autowired
    private UserService userService;
    @Value("${name}")
    private String name;

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String sayHello() {
        return "hello,world," + name;
    }

    @GetMapping("/add")
    public String addUser() {
        User user = new User();
        user.setId(100L);
        user.setName("sunquan");
        user.setAge(100);
        userService.addUser(user);
        return "hello,world," + name;
    }


    @GetMapping("/login")
    public String login() {
        String login = loginService.login();
        return "login-" + login;
    }
}
