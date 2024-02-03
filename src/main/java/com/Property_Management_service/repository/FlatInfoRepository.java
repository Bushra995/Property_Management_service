package com.Property_Management_service.repository;

import com.Property_Management_service.model.FlatInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlatInfoRepository extends JpaRepository<FlatInfo, Long> {




    List<FlatInfo> findAllByLocation(String location);

    @Query("SELECT f FROM FlatInfo f WHERE " +
            "LOWER(f.flatTitle) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(f.location) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(f.type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(f.manualAddress) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(f.propType) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<FlatInfo> searchAllStringProperties(String searchTerm);



//    @Query("SELECT DISTINCT f FROM FlatInfo f JOIN f.Amenities a WHERE a.name = :amenitiesName")
//    List<FlatInfo> findByAmenitiesName(@Param("amenitiesName") String amenitiesName);




}
