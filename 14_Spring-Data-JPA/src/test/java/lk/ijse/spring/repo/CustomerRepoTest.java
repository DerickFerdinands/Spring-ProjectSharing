package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerRepoTest {
    @Autowired
    CustomerRepo repo;

    @Test
    public void testOne() {
        ArrayList<Customer> customerByName = repo.findCustomerByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testTwo() {
        ArrayList<Customer> customerByName = repo.readByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testThree() {
        ArrayList<Customer> customerByName = repo.findCustomerByNameAndAddress("Derick Andrew Ferdinands", "Colombo 7");
        System.out.println(customerByName);

    }

    @Test
    public void testFour() {
        ArrayList<Customer> customerByName = repo.getByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testFive() {
        ArrayList<Customer> customerByName = repo.queryByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testSix() {
        ArrayList<Customer> customerByName = repo.searchByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testSeven() {
        ArrayList<Customer> customerByName = repo.streamByName("Derick Andrew Ferdinands");
        System.out.println(customerByName);

    }

    @Test
    public void testEight() {
        System.out.println(repo.countByName("Derick Andrew Ferdinands"));

    }

    @Test
    public void testNine() {
        System.out.println(repo.existsByName("Derick Andrew Ferdinands"));

    }

    @Test
    public void testTen() {
     repo.deleteByCode("C003");

    }

    @Test
    public void TestEleven() {
        repo.deleteByCode("C003");

    }

    @Test
    public void testTwelve() {
        System.out.println(repo.testnativeQueryOne());

    }

    @Test
    public void testThirteen() {
        System.out.println(repo.testNativeQueryTwo("C001"));

    }

    @Test
    public void testFourteen() {
        System.out.println(repo.testNativeQueryThree("C001", "Colombo 7"));

    }


}