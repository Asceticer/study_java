package com.asceticer.study.controller;

import com.asceticer.study.dao.DepartmentDao;
import com.asceticer.study.dao.EmployeeDao;
import com.asceticer.study.entities.Department;
import com.asceticer.study.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * @Description: 处理员工相关业务请求
 * @Author: Administrator
 * @Date: 2020/3/19 10:48
 * @Version: 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/employees")
    public String listEmployees(ModelMap map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("employees", employees);
        return "employee/list";
    }

    @GetMapping("/employee")
    public String toAddEmployee(ModelMap map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "employee/add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee/employees";
    }

}
