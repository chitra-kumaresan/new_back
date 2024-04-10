package com.example.SpringBootMiniProject1.service;

import com.example.SpringBootMiniProject1.dto.EmployeeDto;
import com.example.SpringBootMiniProject1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
  EmployeeDto getEmployeeById(Long employeeId);
  List<EmployeeDto> getAllEmployees();
   EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
   void deleteEmployee(Long employeeId);


}
