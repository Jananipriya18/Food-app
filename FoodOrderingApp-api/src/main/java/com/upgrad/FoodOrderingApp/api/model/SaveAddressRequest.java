package com.upgrad.FoodOrderingApp.api.model; // Adjust the package name to match your project structure

public class SaveAddressRequest {
    private String flatBuildingName;
    private String city;
    private String locality;
    private String pincode;
    private String stateUuid; // Assuming stateUuid is a reference to a State in your application

    // Add constructors, getters, and setters here

    public String getFlatBuildingName() {
        return flatBuildingName;
    }

    public void setFlatBuildingName(String flatBuildingName) {
        this.flatBuildingName = flatBuildingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getStateUuid() {
        return stateUuid;
    }

    public void setStateUuid(String stateUuid) {
        this.stateUuid = stateUuid;
    }
}
