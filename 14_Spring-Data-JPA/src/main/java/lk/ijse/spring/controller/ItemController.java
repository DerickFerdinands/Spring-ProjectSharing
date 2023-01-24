package lk.ijse.spring.controller;


import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.service.ItemServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService impl;
    @Autowired
    ModelMapper mapper;

    @GetMapping
    public ResponseUtil getItems() {
        return new ResponseUtil("200", "Successful!", impl.getAllItems());
    }

    @PostMapping
    public ResponseUtil addItem(ItemDTO dto) {
        impl.saveItem(dto);
        return new ResponseUtil("200", "Item Saved!", dto);
    }


    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        impl.updateItem(dto);
        return new ResponseUtil("200", "Item Updated!", dto);
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String code) {
        impl.deleteItem(code);
        return new ResponseUtil("200", "Item Deleted!", code);
    }
}
