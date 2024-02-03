package com.Property_Management_service.service;

import com.Property_Management_service.dto.AmenitiesDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AmentitiesService {

    //Amenetities add delete or update or get by id


    Amenities addAmenities(AmenitiesDto amenitiesdto);
    Amenities getAmenitiesById(Long id);
    Amenities updateAmenities(AmenitiesDto amenitiesdto);
    ResponseEntity<ErrorResponse> deleteAmenities(Long id);
}
