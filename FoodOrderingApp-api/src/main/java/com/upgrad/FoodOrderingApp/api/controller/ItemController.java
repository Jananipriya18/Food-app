package com.upgrad.FoodOrderingApp.api.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.FoodOrderingApp.api.model.ItemList;
import com.upgrad.FoodOrderingApp.api.model.ItemListResponse;
import com.upgrad.FoodOrderingApp.service.businness.ItemService;
import com.upgrad.FoodOrderingApp.service.businness.RestaurantService;
import com.upgrad.FoodOrderingApp.service.entity.ItemEntity;
import com.upgrad.FoodOrderingApp.service.entity.RestaurantEntity;
import com.upgrad.FoodOrderingApp.service.exception.RestaurantNotFoundException;

// ItemController Handles all  the Item related endpoints

//Import statements

@RestController
@RequestMapping("/item")
public class ItemController {

 @Autowired
 ItemService itemService;
 
 @Autowired
 RestaurantService restaurantService;

 @CrossOrigin
 @RequestMapping(method = RequestMethod.GET, path = "/restaurant/{restaurant_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public ResponseEntity<ItemListResponse> getTopFiveItemsByPopularity(@PathVariable(value = "restaurant_id") final String restaurantUuid) throws RestaurantNotFoundException {

     RestaurantEntity restaurantEntity = restaurantService.restaurantByUUID(restaurantUuid);
     List<ItemEntity> itemEntities = itemService.getItemsByPopularity(restaurantEntity);

     ItemListResponse itemListResponse = new ItemListResponse();
     List<ItemList> itemList = new ArrayList<>(); // Create a list to store ItemList objects

     itemEntities.forEach(itemEntity -> {
         ItemList item = new ItemList()
                 .id(UUID.fromString(itemEntity.getUuid()))
                 .itemName(itemEntity.getitemName())
                 .price(itemEntity.getPrice())
                 .itemType(ItemList.ItemTypeEnum.fromValue(itemEntity.getType().getValue()));
         itemList.add(item); // Add each item to the list
     });

     itemListResponse.setItems(itemList); // Set the list of items in the itemListResponse

     return new ResponseEntity<ItemListResponse>(itemListResponse, HttpStatus.OK);
 }
}
