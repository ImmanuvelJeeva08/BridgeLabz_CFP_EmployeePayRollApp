/****************************************************************************************************************************
 *
 * Modified the Rest Controller to demonstrate the various HTTP Methods.
 * Introducing DTO and Model to Employee Payroll App.
 * Introducing Services Layer in Employee Payroll App.
 * Ability for the Services Layer to store the Employee Payroll Data.
 * Use Lombok Library to auto generate getters and setters for the DTO.
 * Validation and Exception handing are added.
 *
 * @author : IMMANUVEL JEEVA
 * @since  : 15.09.2021
 *
 ******************************************************************************************************************************/
package com.example.emppay;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpPayApplication {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    public static void main(String[] args) {

        SpringApplication.run(EmpPayApplication.class, args);
    }

}
