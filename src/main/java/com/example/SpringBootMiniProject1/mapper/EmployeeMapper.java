package com.example.SpringBootMiniProject1.mapper;

import com.example.SpringBootMiniProject1.dto.EmployeeDto;
import com.example.SpringBootMiniProject1.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getEmpId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJoinedDate(),
                employee.getEmail(),
                employee.getMobileNumber()

        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getEmpId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getJoinedDate(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber()

        );
    }
}
