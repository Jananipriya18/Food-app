package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;

public class PaymentListResponse {
    private List<PaymentResponse> paymentMethods;

    public List<PaymentResponse> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentResponse> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
