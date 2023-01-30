package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PurchaseDTO;
import lk.ijse.spring.dto.PurchaseDetailDTO;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    OrderService service;
    @PostMapping
    public ResponseUtil purchase(@RequestBody PurchaseDTO dto) {
        System.out.println(dto);
        service.saveOrder(dto);
        return new ResponseUtil("200", "Order Saved!", dto);
    }
}
