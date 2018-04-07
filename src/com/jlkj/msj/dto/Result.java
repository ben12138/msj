package com.jlkj.msj.dto;

/**
 * result实体类
 * 用于控制器返回给前端的json数据对应的实体类
 *
 * @param <T>
 */
public class Result<T> {
    private boolean success;//是否成功
    private T data;//返回的数据
    private int code;

    public Result() {
        // TODO Auto-generated constructor stub
    }

    public Result(boolean success, T data,int code) {
        super();
        this.success = success;
        this.data = data;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
