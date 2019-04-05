package com.caztc.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author CJN
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Response<T> createSuccessResponse(T data) {
        return new Response<>(0, "success", data);
    }

    public static <T> Response<T> createSuccessResponse() {
        return new Response<>(0, "success", null);
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
