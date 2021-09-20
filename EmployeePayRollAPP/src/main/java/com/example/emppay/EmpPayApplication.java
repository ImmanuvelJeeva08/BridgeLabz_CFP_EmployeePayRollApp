/****************************************************************************************************************************
 *
 * Modified the Rest Controller to demonstrate the various HTTP Methods.
 * Introducing DTO and Model to Employee Payroll App.
 * Introducing Services Layer in Employee Payroll App.
 * Ability for the Services Layer to store the Employee Payroll Data.
 * Use Lombok Library to auto generate getters and setters for the DTO.
 * Validation and Exception handing are added.
 *
 * Database setting as Environment variable.
 * Added the concept of Interface.
 * Updated the Bean class and added validation and customized exception.
 * Ability to get employee from DB using department name.
 *
 *
 * @author : IMMANUVEL JEEVA
 * @since  : 15.09.2021
 *
 ******************************************************************************************************************************/
package com.example.emppay;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class EmpPayApplication {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(EmpPayApplication.class, args);
        log.info("Employee Payroll Application Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
        log.info("Inside Main Method.");
    }

}
