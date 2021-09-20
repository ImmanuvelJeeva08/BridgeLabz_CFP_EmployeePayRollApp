package com.example.emppay.repository;

import com.example.emppay.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Purpose : Ability to get employee from DB using department name
     * @param department
     * @return
     */

    @Query(value = "select * from employee, employee_department where emp_id = id and department = :department", nativeQuery = true)
    List<Employee> getEmployeeByDepartment(String department);
}