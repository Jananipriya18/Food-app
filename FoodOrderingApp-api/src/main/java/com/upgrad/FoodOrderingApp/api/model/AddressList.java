package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class AddressList {
    private UUID id;
    private String city;
    private String flatBuildingName;
    private String locality;
    private String pincode;
    private AddressListState state;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatBuildingName() {
        return flatBuildingName;
    }

    public void setFlatBuildingName(String flatBuildingName) {
        this.flatBuildingName = flatBuildingName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public AddressListState getState() {
        return state;
    }

    public void setState(AddressListState state) {
        this.state = state;
    }
}
