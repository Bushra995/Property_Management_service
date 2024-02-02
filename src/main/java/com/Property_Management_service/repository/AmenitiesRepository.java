package com.Property_Management_service.repository;

import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmenitiesRepository  extends JpaRepository<Amenities, Long> {

    @Query("SELECT r FROM amenities r WHERE r.flatInfo.id = ?1")
    List<Amenities> findAllAmenitiesByFlatId(Long flatinfo);
}
