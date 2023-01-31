package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String code;
    private String name;
    private String Description;
    private int buyingPrice;
    private int sellingPrice;
    private int qty;

}
