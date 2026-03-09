package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repo;

    @GetMapping
    public Page<Restaurant> getRestaurants(@RequestParam int page,@RequestParam int size){

        Pageable pageable=PageRequest.of(page,size);

        return repo.findAll(pageable);
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){

        return repo.save(restaurant);
    }

}