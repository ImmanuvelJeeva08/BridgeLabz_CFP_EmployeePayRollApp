package com.example.emppay.service;

import com.example.emppay.dto.EmployeeDTO;
import com.example.emppay.entity.Employee;
import com.example.emppay.exception.EmployeePayrollException;
import com.example.emppay.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService implements InterfaceEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : Ability to add employee details in Employee Payroll
     * @param employeeDTO
     * @return
     */

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        log.info("Inside addEmployee()");
        Employee employeeRequest = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employeeRequest);
        return employeeDTO;
    }

    /**
     * Purpose : Ability to fetch all employee details from Employee Payroll
     * @return
     */

    @Override
    public List<EmployeeDTO> getEmployee() {
        log.info("Inside getEmployee()");
        return employeeRepository.findAll().stream().map(employee -> {
            return new EmployeeDTO(employee.getEmpId(), employee.getEmpName(), employee.getEmpGender(), employee.getEmpAddress(),
                    employee.getEmpSalary(), employee.getStartDate(), employee.getEmpMobileNo(), employee.getEmpEmail(),
                    employee.getNote(), employee.getProfilePic(), employee.getDepartment());
        }).collect(Collectors.toList());
    }

    /**
     * Purpose : Ability to fetch employee details from Employee Payroll using ID
     * @param id
     * @return
     */

    @Override
    public EmployeeDTO getEmployeeByID(int id) {
        log.info("Inside getEmployeeByID()");
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
        log.info("Inside findEmployeeById()");
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Unable to find any Employee Payroll detail!"));
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param id
     * @param employeeDTO
     * @return
     */

    @Override
    public EmployeeDTO updateEmployeeDetails(int id, EmployeeDTO employeeDTO) {
        log.info("Inside updateEmployeeDetails()");
        EmployeeDTO employeeResponse = null;
        if (id > 0) {
            Employee employeeDetails = findEmployeeById(id);
            String[] ignoreFields = {"empId", "empName", "startDate"};
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

    @Override
    public void deleteEmployee(int id) {
        log.info("Inside deleteEmployee()");
        if (id > 0) {
            Employee employee = findEmployeeById(id);
            employeeRepository.delete(employee);
        }
    }

    /**
     * Purpose : Ability to get employee details from Employee Payroll using department
     * @param department
     * @return
     */

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.getEmployeeByDepartment(department);
    }
}
