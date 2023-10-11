package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;
import java.math.BigDecimal;
import com.upgrad.FoodOrderingApp.api.model.ItemList.ItemTypeEnum;


public class ItemQuantityResponseItem {
    private UUID id;
    private String itemName;
    private BigDecimal itemPrice;
    private ItemTypeEnum type;
    
    // Getters and setters for the above fields

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public ItemTypeEnum getType() {
		return type;
	}
	public void setType(ItemTypeEnum type) {
		this.type = type;
	}

    
    
}
