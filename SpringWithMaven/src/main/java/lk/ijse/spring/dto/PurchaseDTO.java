package lk.ijse.spring.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseDTO {
    private String oid;
    private String date;
    private String cusID;
    private ArrayList<PurchaseDetailDTO> orderDetails;

    public PurchaseDTO() {
    }

    public PurchaseDTO(String oid, String date, String cusID, ArrayList<PurchaseDetailDTO> orderDetails) {
        this.oid = oid;
        this.date = date;
        this.cusID = cusID;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", cusID='" + cusID + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public ArrayList<PurchaseDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<PurchaseDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}