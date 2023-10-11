package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;

public class CategoryListResponse {
    private UUID id;
    private String categoryName;

    public UUID getId() {
        return id;
    }

    public CategoryListResponse id(UUID id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryListResponse categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}
