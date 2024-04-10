package com.example.SpringBootMiniProject1.service;

import com.example.SpringBootMiniProject1.dto.EmployeeDto;
import com.example.SpringBootMiniProject1.entity.Employee;
import com.example.SpringBootMiniProject1.repository.EmployeeRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {


        @Mock
        private EmployeeRepo employeeRepo;
        @InjectMocks
        private  EmployeeServiceImpl employeeService;

        private Employee employee;
        @BeforeEach
        public void setUp(){
            employee=Employee.builder()
                    .firstName("chandru")
                    .lastName("kumaresan")
                    .joinedDate(LocalDate.parse("2024-09-07"))
                    .email("chandru803@gmail.com")
                    .mobileNumber("123456")
                    .build();

        }
        @Test
        public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList(){
           Employee employee1=Employee.builder()
                    .firstName("chitra")
                    .lastName("kumaresan")
                    .joinedDate(LocalDate.parse("2024-09-06"))
                    .email("chitrap803@gmail.com")
                    .mobileNumber("123456")
                    .build();

            given(employeeRepo.findAll()).willReturn(List.of(employee,employee1));
            List<EmployeeDto> employeeDtos=employeeService.getAllEmployees();
            assertThat(employeeDtos).isNotNull();
            assertThat(employeeDtos.size()).isEqualTo(2);

        }
        @Test
        public void givenEmployee_whenGetEmployeesById_thenReturnEmployee(){

            given(employeeRepo.findById(employee.getEmpId())).willReturn(Optional.of(employee));
            EmployeeDto buss=employeeService.getEmployeeById(employee.getEmpId());
            assertThat(buss).isNotNull();


        }

}
