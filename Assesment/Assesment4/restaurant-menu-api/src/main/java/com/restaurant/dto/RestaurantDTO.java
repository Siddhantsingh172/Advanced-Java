package com.restaurant.dto;

import jakarta.validation.constraints.*;

public class RestaurantDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @Positive
    private double rating;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public double getRating() { return rating; }

    public void setRating(double rating) { this.rating = rating; }
}