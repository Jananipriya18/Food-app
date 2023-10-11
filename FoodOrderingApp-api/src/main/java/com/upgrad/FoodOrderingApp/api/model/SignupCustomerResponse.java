package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class SignupCustomerResponse {
    private UUID id;
    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
