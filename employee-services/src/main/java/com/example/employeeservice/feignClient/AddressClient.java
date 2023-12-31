package com.example.employeeservice.feignClient;

import com.example.employeeservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//http://localhost:8081/address-app/api/v1/address/1
@FeignClient(name = "add",url = "http://localhost:8081/address-app/api/v1/")
public interface AddressClient {

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);
}
