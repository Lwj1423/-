package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Employee {

	private Integer id;
    private String lastName;

    private String email;
    /**
     *   1 male, 0 female
     */
    private Integer gender;
    private Department department;
    private Date birth;


    public Employee(Integer id, String lastName, String email, Integer gender,
                    Department department) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }

    public Employee() {
    }


	
	
}
