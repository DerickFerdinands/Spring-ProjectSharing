package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PurchaseDTO {
    private String oid;
    private String date;
    private String cusID;
    private ArrayList<PurchaseDetailDTO> orderDetails;
}