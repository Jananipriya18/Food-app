package com.upgrad.FoodOrderingApp.api.model;


import java.util.List;

public class RestaurantListResponse {
    private List<RestaurantList> restaurants;

    public List<RestaurantList> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantList> restaurants) {
        this.restaurants = restaurants;
    }
}