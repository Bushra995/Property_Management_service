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


//    @Query("SELECT DISTINCT f FROM FlatInfo f JOIN f.Amenities a WHERE a.name = :amenitiesName")
//    List<FlatInfo> findByAmenitiesName(@Param("amenitiesName") String amenitiesName);




}
