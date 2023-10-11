package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class ItemList {
    private UUID id;
    private double price;
    private String itemName;
    private ItemTypeEnum itemType;

    public UUID getId() {
        return id;
    }

    public ItemList id(UUID id) {
        this.id = id;
        return this; // Return the current instance
    }

    public double getPrice() {
        return price;
    }

    public ItemList price(double price) {
        this.price = price;
        return this; // Return the current instance
    }

    public String getItemName() {
        return itemName;
    }

    public ItemList itemName(String itemName) {
        this.itemName = itemName;
        return this; // Return the current instance
    }

    public ItemTypeEnum getItemType() {
        return itemType;
    }

    public ItemList itemType(ItemTypeEnum itemType) {
        this.itemType = itemType;
        return this; // Return the current instance
    }

    public enum ItemTypeEnum {
        VEG, NON_VEG;

        public static ItemTypeEnum fromValue(String value) {
            if (value != null) {
                for (ItemTypeEnum itemType : ItemTypeEnum.values()) {
                    if (itemType.name().equalsIgnoreCase(value)) {
                        return itemType;
                    }
                }
            }
            return null;
        }
    }
}
