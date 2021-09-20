package com.example.emppay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private int empId;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "Employee Name Invalid")
    private String empName;

    @Pattern(regexp = "^[a-zA-z0-9]{1,}$", message = "Employee Address Invalid")
    private String empAddress;

    @Min(value = 10000, message = "Min Wage should be more than 10000")
    private double empSalary;

    @Pattern(regexp = "^[0-9]{10}$", message = "Employee Phone Number Invalid")
    private String empMobileNo;

    @Pattern(regexp = "^[A-Z][a-z]{5,}[@][a-z]{5}[.][a-z]{3}$", message = "Employee Email Invalid")
    private String empEmail;

}
