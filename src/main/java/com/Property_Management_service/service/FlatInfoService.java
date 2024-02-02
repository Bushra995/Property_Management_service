package com.Property_Management_service.service;


import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlatInfoService {

    FlatInfo addFlatInfo(FlatInfoDto flatInfoDto);

    FlatInfo getFlatInfoById(Long id);

    List<FlatInfo> getFlatInfoLimitFifty(FlatInfoDto flatInfoDto);

    FlatInfo updateFlatInfo(FlatInfoDto flatInfoDto);

    ResponseEntity<ErrorResponse> deleteFlatInfo (Long id);

//    List<FlatInfo> getFlatInfoByLocation(String Location);

    List<Images> getImagesByFlatId(Long flat_id);

    List<Amenities> getAmenitiesByFlatId(Long flat_Id);



}
