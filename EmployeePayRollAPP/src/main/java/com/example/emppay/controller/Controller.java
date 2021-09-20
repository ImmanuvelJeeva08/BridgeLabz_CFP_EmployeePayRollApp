package com.example.emppay.controller;

import com.example.emppay.dto.EmployeeDTO;
import com.example.emppay.dto.ResponseDTO;
import com.example.emppay.entity.Employee;
import com.example.emppay.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payroll_service")
@Slf4j
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Purpose : Ability to add employee details in Employee Payroll
     * @param employeeDTO
     * @return
     */

    @PostMapping(value = "/addEmployeeDetails")
    public ResponseEntity<ResponseDTO> addEmployeeDetails(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Inside addEmployeeDetails()");
        EmployeeDTO addData = employeeService.addEmployee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added Employee Payroll Details", addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to fetch all employee details from Employee Payroll
     * @return
     */

    @GetMapping(value = "/getEmployeeDetails")
    public ResponseEntity<ResponseDTO> getEmployeeDetails() {
        log.info("Inside getEmployeeDetails()");
        List<EmployeeDTO> employeeList = employeeService.getEmployee();
        ResponseDTO responseDTO = new ResponseDTO("Fetched all Employee Payroll Details", employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to fetch employee details from Employee Payroll using ID
     * @param id
     * @return
     */

    @GetMapping(value = "/getEmployeeDetailsByID")
    public ResponseEntity<ResponseDTO> getEmployeeDetailsByID(@RequestParam(name = "id") int id) {
        log.info("Inside getEmployeeDetailsByID()");
        EmployeeDTO employeeDTO = employeeService.getEmployeeByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched by ID : Employee Payroll Details", employeeDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to update employee details in Employee Payroll using ID
     * @param id
     * @param employeeDTO
     * @return
     */

    @PutMapping(value = "/updateEmployeeDetails")
    public ResponseEntity<ResponseDTO> updateEmployeeDetails(@RequestParam(name = "id") int id,
                                                             @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Inside updateEmployeeDetails()");
        EmployeeDTO updatedData = employeeService.updateEmployeeDetails(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : Employee Payroll Details", updatedData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete employee details from Employee Payroll using ID
     * @param id
     * @return
     */

    @DeleteMapping(value = "/deleteEmployeeDetails")
    public ResponseEntity<ResponseDTO> deleteEmployeeDetails(@RequestParam(name = "id") int id) {
        log.info("Inside deleteEmployeeDetails()");
        employeeService.deleteEmployee(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : Employee Payroll Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to get employee from DB using department name
     * @param department
     * @return
     */

    @GetMapping(value = "/getEmployeeByDepartment")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@RequestParam(name = "department") String department) {
        List<Employee> employeeList = employeeService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Employee By Deprtment", employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
