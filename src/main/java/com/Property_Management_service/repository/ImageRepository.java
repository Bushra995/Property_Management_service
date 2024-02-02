package com.Property_Management_service.repository;


import com.Property_Management_service.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository  extends JpaRepository<Images, Long> {

    @Query("SELECT r FROM images r WHERE r.flatInfo.id = ?1")
    List<Images> findAllImagesByFlatId( Long flatinfo);


}
