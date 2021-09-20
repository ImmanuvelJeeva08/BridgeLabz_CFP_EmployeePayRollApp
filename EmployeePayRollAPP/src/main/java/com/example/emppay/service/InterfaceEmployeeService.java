package com.example.emppay.service;

import com.example.emppay.dto.EmployeeDTO;
import com.example.emppay.entity.Employee;

import java.util.List;

public interface InterfaceEmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getEmployee();
    EmployeeDTO getEmployeeByID(int id);
    EmployeeDTO updateEmployeeDetails(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);

    List<Employee> getEmployeeByDepartment(String department);
}
