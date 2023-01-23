package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PurchaseDTO;
import lk.ijse.spring.dto.PurchaseDetailDTO;
import lk.ijse.spring.util.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {

    @PostMapping
    public ResponseUtil purchase(@RequestBody PurchaseDTO dto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferdfolio", "root", "1234");
            root.setAutoCommit(false);
            PreparedStatement preparedStatement = root.prepareStatement("INSERT INTO orders VALUES (?,?,?)");
            preparedStatement.setObject(1, dto.getOid());
            preparedStatement.setObject(2, dto.getCusID());
            preparedStatement.setObject(3, dto.getDate());
            int i = preparedStatement.executeUpdate();
            System.out.println(dto.getOrderDetails().size());
            if (i > 0) {
                System.out.println("Order Saved!");

                for (PurchaseDetailDTO pd : dto.getOrderDetails()) {
                    PreparedStatement preparedStatement1 = root.prepareStatement("INSERT INTO orderDetail VALUES (?,?,?,?)");
                    preparedStatement1.setObject(1, dto.getOid());
                    preparedStatement1.setObject(2, pd.getCode());
                    preparedStatement1.setObject(3, pd.getQty());
                    preparedStatement1.setObject(4, pd.getPrice());
                    i = preparedStatement1.executeUpdate();
                    System.out.println(pd);
                    if (i > 0) {
                        preparedStatement = root.prepareStatement("UPDATE item SET qty=qty-? WHERE code=?");
                        preparedStatement.setObject(1, pd.getQty());
                        preparedStatement.setObject(2, pd.getCode());
                        i = preparedStatement.executeUpdate();
                        if (i <= 0) {
                            root.rollback();
                            root.setAutoCommit(true);
                        }
                        System.out.println("Item Saved");
                    }
                    if (root.getAutoCommit()==true) {
                        System.out.println("Failed");
                        break;
                    }
                }
                System.out.println("Loop Completed");
                if (!root.getAutoCommit()) {
                    System.out.println("success!");
                    root.commit();
                    root.setAutoCommit(true);
                }
            } else {
                root.rollback();
                root.setAutoCommit(true);
            }

            return new ResponseUtil("200", "Item Updated!", dto);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseUtil("400", e.getMessage(), dto);
        }
   /*     System.out.println(dto);
        System.out.println(dto.getOrderDetails());
        return new ResponseUtil("400", "Done", dto);*/
    }
}
