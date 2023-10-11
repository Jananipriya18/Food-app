package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class LogoutResponse {
    private UUID id;
    private String message;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
