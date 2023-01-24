package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.CustomerServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
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
    CustomerService impl;
    @Autowired
    ModelMapper mapper;
    @GetMapping
    public ResponseUtil getCustomers() {
        return new ResponseUtil("200", "Successful!", impl.getAllCustomers());
    }

    @PostMapping
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        impl.addCustomer(dto);
        return new ResponseUtil("200", "Customer Saved!", dto);

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        impl.addCustomer(dto);
        return new ResponseUtil("200", "Customer Updated!", dto);
    }

    @DeleteMapping

    public ResponseUtil deleteCustomer(String code) {
        impl.deleteCustomer(code);
        return new ResponseUtil("200", "Customer Updated!", code);
    }
}
