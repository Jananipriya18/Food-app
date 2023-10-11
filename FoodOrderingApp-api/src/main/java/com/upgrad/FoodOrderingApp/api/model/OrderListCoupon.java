package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class OrderListCoupon {
    private String couponName;
    private UUID id;
    private int percent;
    
    // Getters and setters for the above fields
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}

   
    
}
