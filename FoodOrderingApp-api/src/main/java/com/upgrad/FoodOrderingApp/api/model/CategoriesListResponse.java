package com.upgrad.FoodOrderingApp.api.model;

import java.util.List;

public class CategoriesListResponse {
    private List<CategoryListResponse> categories;

    public List<CategoryListResponse> getCategories() {
        return categories;
    }

    public CategoriesListResponse categories(List<CategoryListResponse> categories) {
        this.categories = categories;
        return this;
    }
}
