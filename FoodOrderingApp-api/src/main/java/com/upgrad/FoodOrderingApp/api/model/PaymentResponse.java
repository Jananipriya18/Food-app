package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class PaymentResponse {
    private UUID id;
    private String paymentName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
