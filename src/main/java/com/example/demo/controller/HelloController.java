package com.example.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "HelloAPI")
public class HelloController {

    @ApiOperation("测试Hello")
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String HelloWorld(){
        return "Hello World";
    }


}
