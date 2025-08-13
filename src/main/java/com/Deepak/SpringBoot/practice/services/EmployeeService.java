package com.Deepak.SpringBoot.practice.services;

import com.Deepak.SpringBoot.practice.dto.EmployeeDTO;
import com.Deepak.SpringBoot.practice.entities.EmployeeEntity;
import com.Deepak.SpringBoot.practice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeDTO getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return new EmployeeDTO(
                employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getIsActive(),
                employeeEntity.getJoiningDate()
        );
    }
}
