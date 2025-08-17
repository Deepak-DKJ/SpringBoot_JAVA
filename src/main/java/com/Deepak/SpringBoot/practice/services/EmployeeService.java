package com.Deepak.SpringBoot.practice.services;

import com.Deepak.SpringBoot.practice.dto.EmployeeDTO;
import com.Deepak.SpringBoot.practice.entities.EmployeeEntity;
import com.Deepak.SpringBoot.practice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
//    @Autowired
    private final ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    public EmployeeDTO getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO)
    {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
    public List <EmployeeDTO> getAllEmployees()
    {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
