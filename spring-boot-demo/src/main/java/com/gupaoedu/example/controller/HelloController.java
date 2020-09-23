package com.gupaoedu.example.controller;

import com.gupaoedu.example.dao.entity.User;
import com.gupaoedu.example.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class HelloController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/test")
    public String test() {
        User user = new User();
        user.setName("Mic");
        userService.insert(user);
        return "Hello Spring Boot";
    }


    @GetMapping("by-user/{id}")
    public String findByUser(@PathVariable("id") String id) {
        ServiceInstance readingListApplication = loadBalancerClient.choose("ReadingListApplication");
        String url=String.format("http://%s:%s",readingListApplication.getHost(),readingListApplication.getPort()+"/readingList/order/by-user/{id}");


        //String forObject = restTemplate.getForObject("http://localhost:28080/readingList/order/by-user/{id}", String.class, id);
        //String forObject = restTemplate.getForObject(url, String.class, id);
        String forObject = restTemplate.getForObject("http://ReadingListApplication/readingList/order/by-user/{id}", String.class, id);
        return "User:" + id + "," + forObject;
    }
}
