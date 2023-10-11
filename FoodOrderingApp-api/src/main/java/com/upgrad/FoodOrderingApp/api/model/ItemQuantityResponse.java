package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;
import java.math.BigDecimal;

public class ItemQuantityResponse {
    private ItemQuantityResponseItem item;
    private int quantity;
    private BigDecimal price;
    
    // Getters and setters for the above fields

	public ItemQuantityResponseItem getItem() {
		return item;
	}
	public void setItem(ItemQuantityResponseItem item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    
    
}
