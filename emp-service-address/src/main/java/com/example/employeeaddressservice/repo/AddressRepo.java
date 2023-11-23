package com.example.employeeaddressservice.repo;

import com.example.employeeaddressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {

    @Query(nativeQuery = true,value = "select ea.*, e.id as employee_id, e.name as employee_name from emp_serv.address ea join emp_serv.employee e on e.id = ea.employee_id where ea.employee_id = :employeeId ")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);

}
