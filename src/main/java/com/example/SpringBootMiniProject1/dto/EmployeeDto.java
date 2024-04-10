package com.example.SpringBootMiniProject1.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmployeeDto {
    private Long empId;
    private String firstName;
    private String lastName;


    private LocalDate joinedDate;
    private String email;

    private String mobileNumber;


}
