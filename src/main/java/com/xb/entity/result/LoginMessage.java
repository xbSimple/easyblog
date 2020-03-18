package com.xb.entity.result;

import java.io.Serializable;

public class LoginMessage implements Serializable {

    private String url;

    private String message;

    public LoginMessage() {
    }

    public LoginMessage(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
