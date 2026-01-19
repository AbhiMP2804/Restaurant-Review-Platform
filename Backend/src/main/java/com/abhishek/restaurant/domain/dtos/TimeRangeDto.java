package com.abhishek.restaurant.domain.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeRangeDto {
    @NotBlank(message = "Open time must be provided")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$")
    private String openTime;

    @NotBlank(message = "Close time must be provided")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$")
    private String closeTime;
}
