package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customer_code")
    private Customer Customer;
    private String date;
}
