package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class OrderListAddress {
    private UUID id;
    private String flatBuildingName;
    private String locality;
    private String city;
    private String pincode;
    private OrderListAddressState state;
    
    // Getters and setters for the above fields

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public OrderListAddressState getState() {
		return state;
	}
	public void setState(OrderListAddressState state) {
		this.state = state;
	}

    
}
