package io.pragra.learning.novspringjpa.dto;



import java.util.Objects;

public class ResponseDTO {
    public ResponseDTO(Object data, String statusCode, String statusDesc) {
        this.data = data;
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }

    private Object data;
    private String statusCode;
    private String statusDesc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDTO that = (ResponseDTO) o;
        return Objects.equals(data, that.data) && Objects.equals(statusCode, that.statusCode) && Objects.equals(statusDesc, that.statusDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, statusCode, statusDesc);
    }

    @Override
    public String toString() {
        return "responseDTO{" +
                "data=" + data +
                ", statusCode='" + statusCode + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
