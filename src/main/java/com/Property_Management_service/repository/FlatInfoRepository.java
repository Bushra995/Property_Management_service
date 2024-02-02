package com.Property_Management_service.repository;

import com.Property_Management_service.model.FlatInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatInfoRepository extends JpaRepository<FlatInfo, Long> {

    @Query("SELECT f FROM flat_info f LIMIT 50")
    List<FlatInfo> findAllFlats();

    @Query("SELECT r FROM flat_info r WHERE id =?1 ")
    List<FlatInfo> findAllFlatsById(Long id);


    @Query("SELECT r FROM flat_info WHERE Location =?1 ")
    List<FlatInfo> findAllFlatsByLocation(String Location);

    @Query("SELECT DISTINCT f FROM FlatInfo f JOIN f.amenities a WHERE a.name = :amenitiesName")
    List<FlatInfo> findByAmenitiesName(String amenitiesName);

}
