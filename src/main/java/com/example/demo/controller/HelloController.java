package com.example.demo.controller;


import com.example.demo.exception.UserNotExistException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "HelloAPI")
public class HelloController {

    @ApiOperation("测试Hello")
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }


}
