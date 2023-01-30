package lk.ijse.spring.service;

import lk.ijse.spring.dto.PurchaseDTO;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.OrderDetailID;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;
    @Autowired
    CustomerRepo cRepo;
    @Autowired
    ItemRepo iRepo;

    @Autowired
    OrderDetailRepo odRepo;

    @Override
    public void saveOrder(PurchaseDTO dto) {
        if (repo.existsById(dto.getOid())) {
            throw new RuntimeException("Order Id " + dto.getOid() + " Already Exists!");
        }
        Orders orders = new Orders(dto.getOid(), cRepo.getReferenceById(dto.getCusID()), dto.getDate(), null);
        repo.save(orders);
        dto.getOrderDetails().forEach(dtoP -> {
            odRepo.save(new OrderDetail(new OrderDetailID(dto.getOid(), dtoP.getCode()), orders, iRepo.getReferenceById(dtoP.getCode()), Integer.parseInt(dtoP.getQty())));
        });

    }
}
