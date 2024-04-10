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

        @DisplayName("Test whether the passenger get saved in DB")
        @Test
        public void givenEmployee_whenSave_thenReturnSavedEmployee(){
            Employee savedEmployee=employeeRepo.save(employee);
            assertThat(savedEmployee).isNotNull();
            assertThat(savedEmployee.getEmpId()).isGreaterThan(0);


        }
        @Test
        public  void givenPassengerList_whenFindAll_thenPassengerList() {
            Employee employee1 = Employee.builder()
                    .firstName("chandru")
                    .lastName("kumaresan")
                    .joinedDate(LocalDate.parse("2024-03-06"))
                    .email("chandru803@gmail.com")
                    .mobileNumber("123456")
                    .build();


            employeeRepo.save(employee);
            employeeRepo.save(employee1);

            List<Employee> passengerList = employeeRepo.findAll();
            assertThat(passengerList).isNotNull();
            assertThat(passengerList.size()).isEqualTo(2);

        }
        @Test
        public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee(){
            employeeRepo.save(employee);
           Optional<Employee> passengerDb=employeeRepo.findByEmail(employee.getEmail());
            assertThat(passengerDb).isNotNull();

        }
        @Test
        public  void givenPassenger_whenUpdatePassenger_thenReturnUpdatedPassenger(){
            employeeRepo.save(employee);
            Employee savedPassenger=employeeRepo.findById(employee.getEmpId()).get();
            savedPassenger.setEmail("kumar@gmail.com");
            Employee updatedPassenger=employeeRepo.save(savedPassenger);
            assertThat(updatedPassenger.getEmail()).isEqualTo("kumar@gmail.com");
        }
        @Test
        public  void givenEmployee_whenDelete_thenRemoveEmployee(){
            employeeRepo.save(employee);
            employeeRepo.deleteById(employee.getEmpId());
            Optional<Employee> passenger1=employeeRepo.findById(employee.getEmpId());
            assertThat(passenger1).isEmpty();

        }



    }


