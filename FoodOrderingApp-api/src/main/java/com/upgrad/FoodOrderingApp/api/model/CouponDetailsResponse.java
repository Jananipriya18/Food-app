package com.upgrad.FoodOrderingApp.api.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CouponDetailsResponse {
    private String couponName;
    private UUID id;
    private BigDecimal percent;

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

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
    

}


