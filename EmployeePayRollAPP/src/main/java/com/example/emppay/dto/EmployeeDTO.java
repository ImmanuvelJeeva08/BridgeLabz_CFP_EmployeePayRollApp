package com.example.emppay.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private int empId;

    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "Employee Name Invalid")
    private String empName;

    @Pattern(regexp = "Male|Female", message = "Gender needs to be male or female")
    private String empGender;

    @Pattern(regexp = "^[a-zA-z0-9]{1,}$", message = "Employee Address Invalid")
    private String empAddress;

    @Min(value = 10000, message = "Min Wage should be more than 10000")
    private double empSalary;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "StartDate should not be Empty")
    @PastOrPresent(message = "StartDate should be past or today's date")
    private LocalDate startDate;

    @Pattern(regexp = "^[0-9]{10}$", message = "Employee Phone Number Invalid")
    private String empMobileNo;

    @Pattern(regexp = "^[A-Z][a-z]{5,}[@][a-z]{5}[.][a-z]{3}$", message = "Employee Email Invalid")
    private String empEmail;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile Pic cannot be empty")
    private String profilePic;

    @NotNull(message = "Department should not be empty")
    private List<String> department;

}
