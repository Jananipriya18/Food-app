package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;
import java.math.BigDecimal;


public class ItemQuantity {
    private UUID itemId;
    private int quantity;
    private BigDecimal price;
    
    // Getters and setters for the above fields

	public UUID getItemId() {
		return itemId;
	}
	public void setItemId(UUID itemId) {
		this.itemId = itemId;
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
