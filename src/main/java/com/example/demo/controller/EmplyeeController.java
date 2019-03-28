package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmplyeeController {

    //员工信息
    @Autowired
    private EmployeeDao employeeDao;
    
    //部门信息
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
}
