package com.example.employeeservice.service;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import com.example.employeeservice.response.AddressResponse;
import com.example.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;


    public EmployeeService( @Value(("${addressservice.base.url}")) String addressBaseURL,RestTemplateBuilder builder) {

        this.restTemplate = builder
                .rootUri(addressBaseURL)
                .build();
    }


    public EmployeeResponse getEmployeeById(int id) {

        AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);

        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;

    }
}
