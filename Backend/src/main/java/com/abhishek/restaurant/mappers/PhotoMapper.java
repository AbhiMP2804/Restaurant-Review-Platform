package com.abhishek.restaurant.mappers;

import com.abhishek.restaurant.domain.dtos.PhotoDto;
import com.abhishek.restaurant.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
}