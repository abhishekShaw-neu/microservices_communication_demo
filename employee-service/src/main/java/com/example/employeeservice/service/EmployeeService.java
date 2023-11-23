package com.example.employeeservice.service;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import com.example.employeeservice.response.AddressResponse;
import com.example.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;
/*
    @Value(("${addressservice.base.url}"))
    private String addressBaseURL;

 */

    public EmployeeService() {
    }

    public EmployeeResponse getEmployeeById(int id) {

        //AddressResponse addressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}", AddressResponse.class, id);
        AddressResponse addressResponse = webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();


        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);



        return employeeResponse;
    }
}
