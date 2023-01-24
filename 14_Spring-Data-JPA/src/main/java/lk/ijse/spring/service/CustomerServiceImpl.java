package lk.ijse.spring.service;

import jdk.nashorn.internal.parser.TokenType;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl {
    @Autowired
    CustomerRepo repo;
    @Autowired
    ModelMapper mapper;

    public void addCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto,Customer.class));
    }

    public void deleteCustomer(String code) {
        repo.deleteById(code);
    }

    public void updateCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto,Customer.class));
    }

    public ArrayList<CustomerDTO> getAllCustomers(){
        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());

    }
}
