package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PurchaseDTO;
import lk.ijse.spring.dto.PurchaseDetailDTO;
import lk.ijse.spring.util.ResponseUtil;
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
            if (i > 0) {
                for (PurchaseDetailDTO pd : dto.getPurchaseDetails()) {
                    preparedStatement = root.prepareStatement("INSERT INTO orderDetail VALUES (?,?,?,?)");
                    preparedStatement.setObject(1, dto.getOid());
                    preparedStatement.setObject(2, pd.getCode());
                    preparedStatement.setObject(3, pd.getQty());
                    preparedStatement.setObject(4, pd.getPrice());
                    i = preparedStatement.executeUpdate();
                    if (i > 0) {
                        preparedStatement = root.prepareStatement("UPDATE item SET qty=qty-? WHERE code=?");
                        preparedStatement.setObject(1, pd.getQty());
                        preparedStatement.setObject(2, pd.getCode());
                        i = preparedStatement.executeUpdate();
                        if (i <= 0) {
                            root.rollback();
                            root.setAutoCommit(true);
                        }
                    }
                    if (root.getAutoCommit()) {
                        break;
                    }
                }
                if (!root.getAutoCommit()) {
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
    }
}
