package lk.ijse.spring.service;

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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        if(repo.existsById(dto.getCode())){
            throw new RuntimeException("Customer "+dto.getCode()+" Already Exists!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String code) {
        if(!repo.existsById(code)){
            throw new RuntimeException("Customer "+code+" Does Not Exist!");
        }
        repo.deleteById(code);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(!repo.existsById(dto.getCode())){
            throw new RuntimeException("Customer "+dto.getCode()+" Does Not Exist!");
        }
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {}.getType());
    }

    @Override
    public CustomerDTO getCustomerByName(String name) {
        return mapper.map(repo.findCustomerByName(name),CustomerDTO.class) ;
    }
}
