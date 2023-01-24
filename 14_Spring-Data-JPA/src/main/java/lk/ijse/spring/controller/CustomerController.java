package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerRepo repo;

    @GetMapping
    public ResponseUtil getCustomers() {
        List<Customer> all = repo.findAll();
        return new ResponseUtil("200", "Successful!", all);
    }

    @PostMapping
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto.getCode(), dto.getName(), dto.getNic(), dto.getDob(), dto.getAddress(), dto.getSalary());
        repo.save(customer);
        return new ResponseUtil("200", "Customer Saved!", dto);

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        Customer customer = new Customer(dto.getCode(), dto.getName(), dto.getNic(), dto.getDob(), dto.getAddress(), dto.getSalary());
        repo.save(customer);
        return new ResponseUtil("200", "Customer Updated!", dto);
    }

    @DeleteMapping

    public ResponseUtil deleteCustomer(String code) {

        repo.deleteById(code);
        return new ResponseUtil("200", "Customer Updated!", code);
    }
}
