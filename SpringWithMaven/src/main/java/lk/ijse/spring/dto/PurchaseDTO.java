package lk.ijse.spring.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseDTO {
    private String oid;
    private String date;
    private String cusID;
    private ArrayList<PurchaseDetailDTO> purchaseDetails;

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", cusID='" + cusID + '\'' +
                ", purchaseDetails=" + purchaseDetails +
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

    public ArrayList<PurchaseDetailDTO> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(ArrayList<PurchaseDetailDTO> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public PurchaseDTO() {
    }

    public PurchaseDTO(String oid, String date, String cusID, ArrayList<PurchaseDetailDTO> purchaseDetails) {
        this.oid = oid;
        this.date = date;
        this.cusID = cusID;
        this.purchaseDetails = purchaseDetails;
    }
}
