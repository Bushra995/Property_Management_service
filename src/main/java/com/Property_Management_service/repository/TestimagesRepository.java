package com.Property_Management_service.repository;

import com.Property_Management_service.model.Testimages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimagesRepository extends JpaRepository<Testimages  ,Long> {

}
