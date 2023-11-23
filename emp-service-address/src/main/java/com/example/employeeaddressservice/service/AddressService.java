package com.example.employeeaddressservice.service;

import com.example.employeeaddressservice.entity.Address;
import com.example.employeeaddressservice.repo.AddressRepo;
import com.example.employeeaddressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        Address address=addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse=modelMapper.map(address,AddressResponse.class);
        return addressResponse;

    }
}
