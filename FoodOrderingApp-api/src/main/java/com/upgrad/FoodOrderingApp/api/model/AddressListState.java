package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class AddressListState {
    private UUID id;
    private String stateName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
