package com.Deepak.SpringBoot.practice.controllers;

import com.Deepak.SpringBoot.practice.dto.EmployeeDTO;
import com.Deepak.SpringBoot.practice.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/*
* Get /employees
* Add /employees
* Delete /employee/{id}
*/
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // Mandatory Param
    @GetMapping(path = "/api/getEmployees/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    // Optional Param
    @GetMapping(path="/api/getEmployees")
    public String getEmployees(@RequestParam("sortby") String sortBy, @RequestParam("pagenum") Integer pageNum)
    {
        return "NA: " + sortBy + ", "+ pageNum;
    }
}
