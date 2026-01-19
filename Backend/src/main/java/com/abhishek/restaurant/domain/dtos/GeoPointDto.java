package com.abhishek.restaurant.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoPointDto {
    private Double latitude;
    private Double longitude;
}
