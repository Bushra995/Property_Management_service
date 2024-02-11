package com.Property_Management_service.repository;

import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenitiesRepository  extends JpaRepository<Amenities, Long> {

    @Query("SELECT r FROM Amenities r WHERE r.flatInfo.id = ?1")
    List<Amenities> findAllAmenitiesByFlatId(Long flatinfo);
}
