package com.store1.Util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {
    private Integer State;
    private String message;

    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        State = state;
    }

    public JsonResult(Throwable throwable) {
        this.message = throwable.getMessage();
    }

    public JsonResult(Integer state, E data) {
        State = state;
        this.data = data;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
