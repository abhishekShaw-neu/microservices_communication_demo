package com.example.employeeservice.service;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.feignClient.AddressClient;
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

//    @Autowired
//    private EmployeeRepo employeeRepo;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Autowired
//    private AddressClient addressClient;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClient;
/*
    @Value(("${addressservice.base.url}"))
    private String addressBaseURL;

 */

    private  EmployeeRepo employeeRepo;
    private  ModelMapper modelMapper;
    private  AddressClient addressClient;

    private WebClient webClient;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper, AddressClient addressClient) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
  //      this.webClient= webClient;
    }


    public EmployeeService() {
    }

    public EmployeeResponse getEmployeeById(int id) {

        //AddressResponse addressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}", AddressResponse.class, id);
        //AddressResponse addressResponse = webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id);


        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);



        return employeeResponse;
    }
}
