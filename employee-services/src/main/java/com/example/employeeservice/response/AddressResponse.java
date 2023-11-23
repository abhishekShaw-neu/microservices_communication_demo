package com.example.employeeservice.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressResponse {
    private int id;
    private String lane_1;
    private String lane_2;
    private String state;
    private String zip;


}
