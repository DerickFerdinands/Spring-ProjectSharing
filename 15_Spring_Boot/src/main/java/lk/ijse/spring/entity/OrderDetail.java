package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    @EmbeddedId
    private OrderDetailID id;
    @ManyToOne
    private Orders orderId;
    @ManyToOne
    private Item item;
    private int qty;
}
