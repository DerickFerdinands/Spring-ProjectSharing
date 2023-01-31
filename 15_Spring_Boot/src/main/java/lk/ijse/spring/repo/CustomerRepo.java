package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    ArrayList<Customer> findCustomerByName(String name);

    ArrayList<Customer> findCustomerByNameAndAddress(String name, String address);

    ArrayList<Customer> readByName(String name);

    ArrayList<Customer> getByName(String name);

    ArrayList<Customer> queryByName(String name);

    ArrayList<Customer> searchByName(String name);

    ArrayList<Customer> streamByName(String name);

    long countByName(String name);

    boolean existsByName(String name);

    void deleteByCode(String code);

    void removeByCode(String code);

    @Query(value = "select * from Customer", nativeQuery = true)
    ArrayList<Customer> testnativeQueryOne();

    @Query(value = "select * from Customer Where code=?1", nativeQuery = true)
    ArrayList<Customer> testNativeQueryTwo(String code);

    @Query(value = "select * from Customer Where code=:code and address=:address", nativeQuery = true)
    ArrayList<Customer> testNativeQueryThree(@Param("code") String code,@Param("address") String address);
}
