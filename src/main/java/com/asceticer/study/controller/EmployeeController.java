package com.asceticer.study.controller;

import com.asceticer.study.dao.DepartmentDao;
import com.asceticer.study.dao.EmployeeDao;
import com.asceticer.study.entities.Department;
import com.asceticer.study.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public String toSaveEmployee(ModelMap map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "employee/detail";
    }

    @PostMapping("/employee")
    public String saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee/employees";
    }

    @GetMapping("/employee/{id}")
    public String toUpdateEmployee(@PathVariable("id") Integer id, ModelMap map) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        map.put("employee", employee);
        return "employee/detail";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee/employees";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee/employees";
    }

}

