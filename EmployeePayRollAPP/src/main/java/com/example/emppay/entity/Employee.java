package com.example.emppay.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private String empGender;
    private String empAddress;
    private double empSalary;
    private LocalDate startDate;
    private String empMobileNo;
    private String empEmail;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employeeDepartment", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
}
