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
public class Customer {
    @Id
    private String code;
    private String name;
    private String nic;
    private String dob;
    private String address;
    private String salary;


}
