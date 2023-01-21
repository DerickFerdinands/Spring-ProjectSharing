package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping
    public ResponseUtil getItems() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
        ResultSet resultSet = root.prepareStatement("SELECT * FROM Item").executeQuery();
        ArrayList<ItemDTO> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(new ItemDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6)));
        }
        return new ResponseUtil("200", "Successful!", items);
    }

    @PostMapping
    public ResponseUtil addItem(ItemDTO dto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("INSERT INTO Item VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, dto.getCode());
            preparedStatement.setObject(2, dto.getName());
            preparedStatement.setObject(3, dto.getDescription());
            preparedStatement.setObject(4, dto.getBuyingPrice());
            preparedStatement.setObject(5, dto.getSellingPrice());
            preparedStatement.setObject(6, dto.getQty());
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Item Saved!", dto);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseUtil("400", e.getMessage(), dto);
        }
    }


    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("UPDATE Item SET name=?, description=?, buyingprice=?, sellingprice=?, qty=? WHERE code=?");
            preparedStatement.setObject(1, dto.getName());
            preparedStatement.setObject(2, dto.getDescription());
            preparedStatement.setObject(3, dto.getBuyingPrice());
            preparedStatement.setObject(4, dto.getSellingPrice());
            preparedStatement.setObject(5, dto.getQty());
            preparedStatement.setObject(6, dto.getCode());
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Item Updated!", dto);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseUtil("400", e.getMessage(), dto);
        }
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String code ) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            PreparedStatement preparedStatement = root.prepareStatement("DELETE FROM item WHERE code=?");
            preparedStatement.setObject(1,code);
            int i = preparedStatement.executeUpdate();
            return new ResponseUtil("200", "Item Deleted!", code);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

            return new ResponseUtil("400", e.getMessage(), code);

        }
    }
}
