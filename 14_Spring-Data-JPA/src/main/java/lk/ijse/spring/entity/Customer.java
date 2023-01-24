package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private String code;
    private String name;
    private String nic;
    private String dob;
    private String address;
    private String salary;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Customer(String code, String name, String nic, String dob, String address, String salary) {
        this.code = code;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.address = address;
        this.salary = salary;
    }
}
