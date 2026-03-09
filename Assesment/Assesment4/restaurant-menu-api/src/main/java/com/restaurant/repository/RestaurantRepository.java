package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{

}