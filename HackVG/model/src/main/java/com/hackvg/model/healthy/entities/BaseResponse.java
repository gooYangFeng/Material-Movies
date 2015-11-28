package com.hackvg.model.healthy.entities;

/**
 * Created by yangfeng on 15/10/3.
 */
public class BaseResponse<T> {
    private int code;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private T data;
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
