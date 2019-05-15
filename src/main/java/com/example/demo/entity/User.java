package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class User  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer userId;

    private String userName;

    private Integer registerTime;

    private String password;

    private String phone;

    private Integer age;

    public User(String userName, Integer registerTime){
        this.userName = userName;
        this.registerTime = registerTime;
    }



    public User(){

    }

    public User(Integer userId,String password,String phone,String userName, Integer age) {
        this.userName = userName;
        this.age = age;
        this.userId = userId;
        this.password = password;
        this.phone = phone;
    }


}