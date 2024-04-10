package com.example.SpringBootMiniProject1.controller;

import com.example.SpringBootMiniProject1.dto.EmployeeDto;
import com.example.SpringBootMiniProject1.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    //Build Add Employee REST API

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
      EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }
    //Build Get Employee REST API

    @GetMapping("{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") Long employeeId){
       EmployeeDto savedEmployee= employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(savedEmployee);

    }
    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List <EmployeeDto> employeeDtoList=employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtoList);
    }
    //Build update Employee REST API
    @PutMapping("{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("empId")Long employeeId,@RequestBody @Valid EmployeeDto updatedEmployee){
        EmployeeDto updatedEmployees=employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(updatedEmployees);
    }
    //Build Delete Employee REST API
    @DeleteMapping("{empId}")
    public ResponseEntity<String> deleteEmployees(@PathVariable("empId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }



}
