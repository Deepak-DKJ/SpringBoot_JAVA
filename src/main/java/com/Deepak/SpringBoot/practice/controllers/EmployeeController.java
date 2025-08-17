package com.Deepak.SpringBoot.practice.controllers;

import com.Deepak.SpringBoot.practice.dto.EmployeeDTO;
import com.Deepak.SpringBoot.practice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Get /employees
* Add /employees
* Delete /employee/{id}
*/
@RestController
@RequestMapping(path="/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // Mandatory Param
    @GetMapping(path = "getEmployees/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    // Optional Param
    @GetMapping(path="/getEmployees")
    public String getEmployees(@RequestParam("sortby") String sortBy, @RequestParam("pagenum") Integer pageNum)
    {
        return "NA: " + sortBy + ", "+ pageNum;
    }

    @PostMapping(path = "/addEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping(path="/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path="/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") Long empId)
    {
        employeeService.deleteEmployee(empId);
    }
}
