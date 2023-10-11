package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;
import java.util.List;

public class CategoryList {
    private UUID id;
    private String categoryName;
    private List<ItemList> itemList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }
}
