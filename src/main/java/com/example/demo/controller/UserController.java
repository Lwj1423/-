package com.example.demo.controller;

import com.example.demo.entity.Demo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户API")
public class UserController {

    @Autowired
    private Demo demo;

    @Value("${ip}")
    private String ip;

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户新增")
    @RequestMapping(value = "/getDemo",method = RequestMethod.GET)
    public String getHost(){
        return "ip: "+demo.getCode()+", ip: "+ ip ;
    }


    @ApiOperation(value = "用户查询")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable("id")Integer id){
        User user = userService.getUser(id);
        return user.getUserName();
    }
}
