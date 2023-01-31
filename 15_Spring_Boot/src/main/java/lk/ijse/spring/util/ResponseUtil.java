package lk.ijse.spring.util;

public class ResponseUtil {

    private String Code;
    private String message;
    private Object data;

    public ResponseUtil() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseUtil(String code, String message, Object data) {
        Code = code;
        this.message = message;
        this.data = data;
    }
}
