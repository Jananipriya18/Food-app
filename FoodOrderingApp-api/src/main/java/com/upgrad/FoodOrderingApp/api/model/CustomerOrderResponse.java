package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;

public class CustomerOrderResponse {
    private List<OrderList> orders;

    public List<OrderList> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderList> orders) {
        this.orders = orders;
    }
}
