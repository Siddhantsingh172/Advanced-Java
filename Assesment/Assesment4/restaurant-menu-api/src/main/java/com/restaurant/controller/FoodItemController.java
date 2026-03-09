package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restaurant.entity.FoodItem;
import com.restaurant.repository.FoodItemRepository;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    @Autowired
    private FoodItemRepository repo;

    @PostMapping("/{restaurantId}/fooditems")
    public FoodItem addFood(@PathVariable Long restaurantId,@RequestBody FoodItem food){

        food.setRestaurantId(restaurantId);

        return repo.save(food);
    }

    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItem> getFood(@PathVariable Long restaurantId){

        return repo.findByRestaurantId(restaurantId);
    }

}