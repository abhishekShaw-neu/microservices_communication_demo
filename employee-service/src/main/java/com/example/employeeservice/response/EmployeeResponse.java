package com.example.employeeservice.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class EmployeeResponse {

    private int id;
    private String name;

    private String email;

    private AddressResponse addressResponse;

    //do not use underscore -- check for naming good practice
    private String blood_group;



}
