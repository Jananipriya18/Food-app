package com.upgrad.FoodOrderingApp.api.model;

import java.util.UUID;
import java.math.BigDecimal;

public class RestaurantList {
    private UUID id;
    private String restaurantName;
    private BigDecimal averagePrice;
    private String categories;
    private BigDecimal customerRating;
    private Integer numberCustomersRated;
    private String photoURL;
    private RestaurantDetailsResponseAddress address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public BigDecimal getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(BigDecimal customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumberCustomersRated() {
        return numberCustomersRated;
    }

    public void setNumberCustomersRated(Integer numberCustomersRated) {
        this.numberCustomersRated = numberCustomersRated;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public RestaurantDetailsResponseAddress getAddress() {
        return address;
    }

    public void setAddress(RestaurantDetailsResponseAddress address) {
        this.address = address;
    }
}
