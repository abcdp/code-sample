package com.charter.enterprise.motd;

public class MessageResource {

    public MessageResource(String message, String securityKey) {
        this.message = message;
        this.securityKey = securityKey;
    }

    String message;
    String securityKey;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getSecurityKey() {
        return securityKey;
    }
}
