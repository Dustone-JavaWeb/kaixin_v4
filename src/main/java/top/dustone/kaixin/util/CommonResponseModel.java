package top.dustone.kaixin.util;

public class CommonResponseModel<T> {
    private String msg;
    private String code;
    private T t;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "CommonResponseModel{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", t=" + t +
                '}';
    }
}
