package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping
    public ResponseUtil getCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
        ResultSet resultSet = root.prepareStatement("SELECT * FROM Customer").executeQuery();

        while (resultSet.next()) {
            customers.add(new CustomerDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4) + "", resultSet.getString(5), resultSet.getString(6) + ""));
        }
        return new ResponseUtil("200", "Successful!", customers);
    }

    @PostMapping
    public ResponseUtil saveCustomer( CustomerDTO dto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, dto.getCode());
            preparedStatement.setObject(2, dto.getName());
            preparedStatement.setObject(3, dto.getNic());
            preparedStatement.setObject(4, dto.getDob());
            preparedStatement.setObject(5, dto.getAddress());
            preparedStatement.setObject(6, dto.getSalary());
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Customer Saved!", dto);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseUtil("400", e.getMessage(), dto);
        }
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("UPDATE customer SET name=?, nic=?, dob=?, address=?, salary=? WHERE code=?");
            preparedStatement.setObject(1, dto.getName());
            preparedStatement.setObject(2, dto.getNic());
            preparedStatement.setObject(3, dto.getDob());
            preparedStatement.setObject(4, dto.getAddress());
            preparedStatement.setObject(5, dto.getSalary());
            preparedStatement.setObject(6, dto.getCode());
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Customer Updated!", dto);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseUtil("400", e.getMessage(), dto);
        }
    }

    @DeleteMapping

    public ResponseUtil deleteCustomer(String code){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("DELETE FROM customer WHERE code=?");
            preparedStatement.setObject(1,code);
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Customer Deleted!", code);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            return new ResponseUtil("400", e.getMessage(), code);

        }
    }
}
