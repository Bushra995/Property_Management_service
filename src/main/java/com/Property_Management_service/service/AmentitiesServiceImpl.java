package com.Property_Management_service.service;

import com.Property_Management_service.dto.AmenitiesDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.repository.AmenitiesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AmentitiesServiceImpl implements  AmentitiesService{


    @Autowired
    private AmenitiesRepository amenitiesRepository;
    @Override
    public Amenities addAmenities(AmenitiesDto amenitiesDto) {
        Amenities  amenities = new Amenities();
        BeanUtils.copyProperties(amenitiesDto, amenities);
        return amenitiesRepository.save(amenities);
    }

    @Override
    public Amenities getAmenitiesById(Long id) {
        Optional<Amenities> amenitiesOptional = amenitiesRepository.findById(id);
        if(amenitiesOptional.isPresent()){
            return amenitiesOptional.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Amenities updateAmenities(AmenitiesDto amenitiesDto) {
        Optional<Amenities> existAmenitiesOptional = amenitiesRepository.findById(amenitiesDto.getAmId());
        if(existAmenitiesOptional.isPresent()) {
            BeanUtils.copyProperties(amenitiesDto, existAmenitiesOptional.get());
            return amenitiesRepository.save(existAmenitiesOptional.get());
        }
        else {
            return null;
        }

    }

    @Override
    public ResponseEntity<ErrorResponse> deleteAmenities(Long id) {
        Optional<Amenities> ExistingAmentity = this.amenitiesRepository.findById(id);

        if (ExistingAmentity.isPresent()) {

            amenitiesRepository.delete(ExistingAmentity.get());
            ErrorResponse SuccessResponse = new ErrorResponse("Amentity with id " + id + "  deleted successfully", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Amentity with id " + id + " not found", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
