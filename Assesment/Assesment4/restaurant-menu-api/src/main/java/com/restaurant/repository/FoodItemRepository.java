package com.restaurant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurant.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long>{

    List<FoodItem> findByRestaurantId(Long restaurantId);

}