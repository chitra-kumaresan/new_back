package com.example.SpringBootMiniProject1.repository;
import com.example.SpringBootMiniProject1.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepoTest {

        @Autowired
        private EmployeeRepo employeeRepo;
        private Employee employee;


        @BeforeEach
        public void setUp(){
            employee=Employee.builder()
                    .firstName("chitra")
                    .lastName("kumaresan")
                    .joinedDate(LocalDate.parse("2024-09-06"))
                    .email("chitrap803@gmail.com")
                    .mobileNumber("123456")
                    .build();
        }
//Post method testcase
        @DisplayName("Test whether the passenger get saved in DB")
        @Test
        public void givenEmployee_whenSave_thenReturnSavedEmployee(){
            Employee savedEmployee=employeeRepo.save(employee);
            assertThat(savedEmployee).isNotNull();
            assertThat(savedEmployee.getEmpId()).isGreaterThan(0);


        }
//GET All testcase
        @Test
        public  void givenEmployeeList_whenFindAll_thenEmployeeList() {
            Employee employee1 = Employee.builder()
                    .firstName("chandru")
                    .lastName("kumaresan")
                    .joinedDate(LocalDate.parse("2024-03-06"))
                    .email("chandru803@gmail.com")
                    .mobileNumber("123456")
                    .build();


            employeeRepo.save(employee);
            employeeRepo.save(employee1);

            List<Employee> employeeList = employeeRepo.findAll();
            assertThat(employeeList).isNotNull();
            assertThat(employeeList.size()).isEqualTo(2);

        }
        
//get by email
        @Test
        public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee(){
            employeeRepo.save(employee);
           Optional<Employee> employeeDb=employeeRepo.findByEmail(employee.getEmail());
            assertThat(employeeDb).isNotNull();

        }
//update employee
        @Test
        public  void givenEmployee_whenUpdateEmployee_thenReturnUpdatedEmployee(){
            employeeRepo.save(employee);
            Employee savedEmployee=employeeRepo.findById(employee.getEmpId()).get();
            savedEmployee.setEmail("kumar@gmail.com");
            Employee updatedEmployee=employeeRepo.save(savedEmployee);
            assertThat(updatedEmployee.getEmail()).isEqualTo("kumar@gmail.com");
        }
//delete employee
        @Test
        public  void givenEmployee_whenDelete_thenRemoveEmployee(){
            employeeRepo.save(employee);
            employeeRepo.deleteById(employee.getEmpId());
            Optional<Employee> employee1=employeeRepo.findById(employee.getEmpId());
            assertThat(employee1).isEmpty();

        }



    }


