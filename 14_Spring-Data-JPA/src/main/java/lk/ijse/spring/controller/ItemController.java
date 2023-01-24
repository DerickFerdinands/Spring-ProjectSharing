package lk.ijse.spring.controller;


import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemRepo repo;

    @GetMapping
    public ResponseUtil getItems() {
        List<Item> all = repo.findAll();
        return new ResponseUtil("200", "Successful!", all);
    }

    @PostMapping
    public ResponseUtil addItem(ItemDTO dto) {
        repo.save(new Item(dto.getCode(), dto.getName(), dto.getDescription(), dto.getBuyingPrice(), dto.getSellingPrice(), dto.getQty()));
        return new ResponseUtil("200", "Item Saved!", dto);
    }


    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        repo.save(new Item(dto.getCode(), dto.getName(), dto.getDescription(), dto.getBuyingPrice(), dto.getSellingPrice(), dto.getQty()));
        return new ResponseUtil("200", "Item Updated!", dto);
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String code) {
        repo.deleteById(code);
        return new ResponseUtil("200", "Item Deleted!", code);
    }
}
