package com.abhishek.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoLocation {
    private Double latitude;
    private Double longitude;
}
