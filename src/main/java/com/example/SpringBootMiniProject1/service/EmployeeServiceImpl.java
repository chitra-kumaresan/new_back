package com.example.SpringBootMiniProject1.service;

import com.example.SpringBootMiniProject1.dto.EmployeeDto;
import com.example.SpringBootMiniProject1.entity.Employee;
import com.example.SpringBootMiniProject1.exception.EmailAlreadyExist;
import com.example.SpringBootMiniProject1.exception.ResourceNotFoundException;
import com.example.SpringBootMiniProject1.exception.ResourceNotFoundNameException;
import com.example.SpringBootMiniProject1.mapper.EmployeeMapper;
import com.example.SpringBootMiniProject1.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       Optional<Employee> employee=employeeRepo.findByEmail(employeeDto.getEmail());
   if(employee.isPresent()){
       throw new EmailAlreadyExist("Email Already exist");
   }
      Employee employee1 = EmployeeMapper.mapToEmployee(employeeDto);
      Employee employee2=employeeRepo.save(employee1);
      return EmployeeMapper.mapToEmployeeDto(employee2);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee2= employeeRepo.findById(employeeId)
               .orElseThrow(()->new ResourceNotFoundNameException("Employee", "id" ,employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee2);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees =employeeRepo.findAll();
        return employees.stream()
                .map((EmployeeMapper::mapToEmployeeDto))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepo.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundNameException("Employee", "id" ,employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setJoinedDate(updatedEmployee.getJoinedDate());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setMobileNumber(updatedEmployee.getMobileNumber());
       Employee updatedEmployees=employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployees);
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundNameException("Employee", "id" ,employeeId));
        employeeRepo.deleteById(employeeId);

    }
}
