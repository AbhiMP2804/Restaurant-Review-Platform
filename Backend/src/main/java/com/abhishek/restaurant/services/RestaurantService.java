package com.abhishek.restaurant.services;

import com.abhishek.restaurant.domain.RestaurantCreateUpdateRequest;
import com.abhishek.restaurant.domain.entities.Restaurant;

public interface RestaurantService {
    // Creates a new restaurant and returns the created entity
    Restaurant createRestaurant(RestaurantCreateUpdateRequest restaurant);
}