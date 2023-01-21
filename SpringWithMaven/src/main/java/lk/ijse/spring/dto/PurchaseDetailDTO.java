package lk.ijse.spring.dto;

public class PurchaseDetailDTO {
    private String code;
    private String qty;
    private String price;

    public PurchaseDetailDTO() {
    }

    public PurchaseDetailDTO(String code, String qty, String price) {
        this.code = code;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PurchaseDetailDTO{" +
                "code='" + code + '\'' +
                ", qty='" + qty + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
