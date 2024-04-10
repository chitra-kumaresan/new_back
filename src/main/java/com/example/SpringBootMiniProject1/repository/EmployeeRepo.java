package com.example.SpringBootMiniProject1.repository;

import com.example.SpringBootMiniProject1.entity.Employee;
import com.example.SpringBootMiniProject1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
}
