package com.abhishek.restaurant.services;

import com.abhishek.restaurant.domain.GeoLocation;
import com.abhishek.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
