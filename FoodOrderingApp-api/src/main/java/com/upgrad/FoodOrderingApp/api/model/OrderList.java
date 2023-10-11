package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;
import java.math.BigDecimal;

// Getters and setters for the above fields

public class OrderList {
    private String id;
    private List<ItemQuantityResponse> itemQuantities;
    private OrderListAddress address;
    private BigDecimal bill;
    private String date;
    private BigDecimal discount;
    private OrderListCoupon coupon;
    private OrderListCustomer customer;
    private OrderListPayment payment;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ItemQuantityResponse> getItemQuantities() {
		return itemQuantities;
	}
	public void setItemQuantities(List<ItemQuantityResponse> itemQuantities) {
		this.itemQuantities = itemQuantities;
	}
	public OrderListAddress getAddress() {
		return address;
	}
	public void setAddress(OrderListAddress address) {
		this.address = address;
	}
	public BigDecimal getBill() {
		return bill;
	}
	public void setBill(BigDecimal bill) {
		this.bill = bill;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public OrderListCoupon getCoupon() {
		return coupon;
	}
	public void setCoupon(OrderListCoupon coupon) {
		this.coupon = coupon;
	}
	public OrderListCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(OrderListCustomer customer) {
		this.customer = customer;
	}
	public OrderListPayment getPayment() {
		return payment;
	}
	public void setPayment(OrderListPayment payment) {
		this.payment = payment;
	}

    
}
