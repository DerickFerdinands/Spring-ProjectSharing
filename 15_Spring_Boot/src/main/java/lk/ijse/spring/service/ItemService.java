package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    void saveItem(ItemDTO dto);

    void updateItem(ItemDTO dto);

    void deleteItem(String code);

    ArrayList<ItemDTO> getAllItems();
}
