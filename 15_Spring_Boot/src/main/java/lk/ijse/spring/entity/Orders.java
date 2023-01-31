package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    private String orderId;
    @ManyToOne
    private Customer code;
    private String date;
    @OneToMany(mappedBy = "orderId")
    private List<OrderDetail> orderDetailList;
}
