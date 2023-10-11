package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;

public class ItemListResponse {
    private List<ItemList> items;

    public List<ItemList> getItems() {
        return items;
    }

    public void setItems(List<ItemList> items) {
        this.items = items;
    }
}
