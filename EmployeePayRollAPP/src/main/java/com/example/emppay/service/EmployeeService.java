package com.example.emppay.service;

import com.example.emppay.dto.EmployeeDTO;
import com.example.emppay.entity.Employee;
import com.example.emppay.exception.EmployeePayrollException;
import com.example.emppay.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : Ability to add employee details in Employee Payroll
     * @param employeeDTO
     * @return
     */

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employeeRequest = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employeeRequest);
        return employeeDTO;
    }

    /**
     * Purpose : Ability to fetch all employee details from Employee Payroll
     * @return
     */

    public List<EmployeeDTO> getEmployee() {
        return employeeRepository.findAll().stream().map(employee -> new EmployeeDTO(
                employee.getEmpId(), employee.getEmpName(), employee.getEmpAddress(),
                employee.getEmpSalary(), employee.getEmpMobileNo(), employee.getEmpEmail())).
                collect(Collectors.toList());
    }

    /**
     * Purpose : Ability to fetch employee details from Employee Payroll using ID
     * @param id
     * @return
     */

    public EmployeeDTO getEmployeeByID(int id) {
        Employee employee = findEmployeeById(id);
        EmployeeDTO employeeResponse = modelMapper.map(employee, EmployeeDTO.class);
        return employeeResponse;
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param id
     * @return
     */

    private Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Unable to find any Employee Payroll detail!"));
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param id
     * @param employeeDTO
     * @return
     */

    public EmployeeDTO updateEmployeeDetails(int id, EmployeeDTO employeeDTO) {
        EmployeeDTO employeeResponse = null;
        if (id > 0) {
            Employee employeeDetails = findEmployeeById(id);
            String[] ignoreFields = {"empId", "empName"};
            BeanUtils.copyProperties(employeeDTO, employeeDetails, ignoreFields);
            employeeRepository.save(employeeDetails);
            employeeResponse = modelMapper.map(employeeDetails, EmployeeDTO.class);
        }
        return employeeResponse;
    }

    /**
     * Purpose : Ability to delete employee details from Employee Payroll using ID
     * @param id
     * @return
     */

    public EmployeeDTO deleteEmployee(int id) {
        EmployeeDTO employeeResponse = null;
        if (id > 0) {
            Employee employee = findEmployeeById(id);
            employeeRepository.delete(employee);
            employeeResponse = modelMapper.map(employee, EmployeeDTO.class);
        }
        return employeeResponse;
    }
}