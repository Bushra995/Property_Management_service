package com.Property_Management_service.repository;

import com.Property_Management_service.model.FlatInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlatInfoRepository extends JpaRepository<FlatInfo, Long> {




    List<FlatInfo> findAllByLocation(String location);



    @Query("SELECT DISTINCT f FROM FlatInfo f " +
            "LEFT JOIN f.amenities a " +
            "WHERE " +
            "(LENGTH(:searchTerm) >= 3 AND (" +
            "   LOWER(f.flatTitle) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   LOWER(f.location) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   LOWER(f.type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   LOWER(f.manualAddress) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   LOWER(f.propType) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   CAST(f.pinCode AS string) LIKE :searchTerm OR " +
            "   LOWER(f.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "   LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')))) OR " +
            "(LENGTH(:searchTerm) < 3 AND false)")
    Page<FlatInfo> searchAllStringPropertiesPageble(String searchTerm , Pageable pageable);

    @Query("SELECT DISTINCT f FROM FlatInfo f " +
            "JOIN f.amenities a " +
            "WHERE (LENGTH(:amenitiesName) >= 3 AND LOWER(a.name) LIKE LOWER(CONCAT('%', :amenitiesName, '%')))")
    Page<FlatInfo> findByAmenitiesName(@Param("amenitiesName") String amenitiesName , Pageable pageable);


}
