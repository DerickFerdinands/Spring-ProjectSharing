package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(OrderDetailID.class)
public class OrderDetail {

    @EmbeddedId
    private OrderDetailID id;
    @OneToOne
    private Orders order;
    @ManyToMany(mappedBy = "orderDetail")
    private List<Item> itemList;
    private int qty;
}
