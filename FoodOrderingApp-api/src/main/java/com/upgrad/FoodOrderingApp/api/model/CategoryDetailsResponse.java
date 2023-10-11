package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;
import java.util.UUID;

public class CategoryDetailsResponse {
    private UUID id;
    private String categoryName;
    private List<ItemList> itemList;

    public UUID getId() {
        return id;
    }

    public CategoryDetailsResponse id(UUID id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryDetailsResponse categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public List<ItemList> getItemList() {
        return itemList;
    }

    public CategoryDetailsResponse itemList(List<ItemList> itemList) {
        this.itemList = itemList;
        return this;
    }
}
