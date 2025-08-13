package com.Deepak.SpringBoot.practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;

/*
* Get /employees
* Add /employees
* Delete /employee/{id}
*/
@RestController
public class EmployeeController {
    @GetMapping(path = "/api/getEmployees")
    public String getEmployees()
    {
        return "Deepak, Rahul.";
    }
}
