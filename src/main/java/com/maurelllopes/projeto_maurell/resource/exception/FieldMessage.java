package com.maurelllopes.projeto_maurell.resource.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fildName;
    private String message;

    public FieldMessage(){

    }

    public FieldMessage(String fildName, String message) {
        this.setFildName(fildName);
        this.setMessage(message);
    }

    public String getFildName() {
        return fildName;
    }

    public void setFildName(String fildName) {
        this.fildName = fildName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}