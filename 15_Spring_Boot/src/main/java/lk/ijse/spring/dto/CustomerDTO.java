package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String code;
    private String name;
    private String nic;
    private String dob;
    private String address;
    private String salary;

}
