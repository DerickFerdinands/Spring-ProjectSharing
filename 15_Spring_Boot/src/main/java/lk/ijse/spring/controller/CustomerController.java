package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(params = "{name}")
    public ResponseUtil searchCustomerByName(String name){
        CustomerDTO customer = impl.getCustomerByName(name);
        return new ResponseUtil("200", "Customer Found!", customer);

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
