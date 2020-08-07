package com.demo.news;

import java.io.Serializable;

public class DataMessage implements Serializable {
    private static final long serialVersionUID = -5484872509941191664L;
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public DataMessage(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DataMessage() {
    }

    public static DataMessage success(Object data){
        return new DataMessage(200,"成功",data);
    }

    public static DataMessage fail(String exceptionMsg){
        return new DataMessage(500,"后台请求异常，请联系开发人员",exceptionMsg);
    }

    public static DataMessage failMsg(String msg){
        return new DataMessage(500,msg,null);
    }

    public  static  DataMessage failCode(Integer code,String msg){
        return new DataMessage(code,msg,null);
    }
}
