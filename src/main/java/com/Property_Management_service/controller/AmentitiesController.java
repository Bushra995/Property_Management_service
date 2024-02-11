package com.Property_Management_service.controller;

import com.Property_Management_service.dto.AmenitiesDto;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.service.AmentitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.Property_Management_service.exception.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amenities")
public class AmentitiesController {
    private final AmentitiesService amentitiesService;

    @Autowired
    public AmentitiesController(AmentitiesService amentitiesService) {
        this.amentitiesService = amentitiesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Amenities> addAmenities(@RequestBody AmenitiesDto amenitiesDto) {
        Amenities addedAmenities = amentitiesService.addAmenities(amenitiesDto);
        if (addedAmenities != null) {
            return ResponseEntity.ok(addedAmenities);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Amenities> getAmenitiesById(@PathVariable Long id) {
        Amenities amenities = amentitiesService.getAmenitiesById(id);
        if (amenities != null) {
            return ResponseEntity.ok(amenities);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Amenities> updateAmenities(@RequestBody AmenitiesDto amenitiesDto) {
        Amenities updatedAmenities = amentitiesService.updateAmenities(amenitiesDto);
        if (updatedAmenities != null) {
            return ResponseEntity.ok(updatedAmenities);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ErrorResponse> deleteAmenities(@PathVariable Long id) {
        return amentitiesService.deleteAmenities(id);
    }
}
