package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveItem(ItemDTO dto){
        repo.save(mapper.map(dto, Item.class));
    }
    @Override
    public void updateItem(ItemDTO dto){
        repo.save(mapper.map(dto, Item.class));
    }
    @Override
    public void deleteItem(String code){
        repo.deleteById(code);
    }
    @Override
    public ArrayList<ItemDTO> getAllItems(){
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<ItemDTO>>(){}.getType());
    }
}
