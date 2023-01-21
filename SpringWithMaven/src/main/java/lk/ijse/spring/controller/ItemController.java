package lk.ijse.spring.controller;


import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping
    public ResponseUtil getItems() {
        return new ResponseUtil();
    }

    @PostMapping
    public ResponseUtil addItem(ItemDTO dto) {
    return new ResponseUtil();
    }


    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        return new ResponseUtil();
    }

    @DeleteMapping
    public ResponseUtil deleteItem(@RequestBody ItemDTO dto) {
        return new ResponseUtil();
    }
}
