package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {
    @Id
    private String code;
    private String name;
    private String Description;
    private int buyingPrice;
    private int sellingPrice;
    private int qty;



}
