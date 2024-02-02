package com.Property_Management_service.service;

import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import com.Property_Management_service.repository.AmenitiesRepository;
import com.Property_Management_service.repository.FlatInfoRepository;
import com.Property_Management_service.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatInfoServiceImpl implements FlatInfoService {

    @Autowired
    private FlatInfoRepository flatInfoRepository;

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public FlatInfo addFlatInfo(FlatInfoDto flatInfoDto) {

        Optional<FlatInfo> existingflatinfo = this.flatInfoRepository.findById(flatInfoDto.getId());
        if(existingflatinfo==null) {
            FlatInfo flatInfo = new FlatInfo();
            BeanUtils.copyProperties(flatInfoDto, flatInfo);
            return flatInfoRepository.save(flatInfo);
        }
        else {
            return null;
        }
    }

    @Override
    public FlatInfo getFlatInfoById(Long id) {

        return flatInfoRepository.getById(id);
    }

    @Override
    public List<FlatInfo> getFlatInfoLimitFifty(FlatInfoDto flatInfoDto) {
        return flatInfoRepository.findAll().subList(0, Math.min(50, flatInfoRepository.findAll().size()));
    }

    @Override
    public FlatInfo updateFlatInfo(FlatInfoDto flatInfoDto) {
        FlatInfo existingFlatInfo = flatInfoRepository.getById(flatInfoDto.getId());
        if(existingFlatInfo!=null){
        BeanUtils.copyProperties(flatInfoDto, existingFlatInfo);
        return flatInfoRepository.save(existingFlatInfo);
        }
        else {
            return null;
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> deleteFlatInfo(Long id) {
        FlatInfo flatInfo = getFlatInfoById(id);
        if(flatInfo!=null){
        flatInfoRepository.delete(flatInfo);
        ErrorResponse SuccessResponse = new ErrorResponse("FlatInfo with id " + id + "  deleted successfully", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse);
        }
        else {
            ErrorResponse errorResponse = new ErrorResponse("FlatInfo with id " + id + " not found", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Override
    public List<FlatInfo> getFlatInfoByLocation(String location) {
        return flatInfoRepository.findAllFlatsByLocation(location);
    }

    @Override
    public List<Images> getImagesByFlatId(Long flat_id) {
        return imageRepository.findAllImagesByFlatId(flat_id);
    }

    @Override
    public List<Amenities> getAmenitiesByFlatId(Long flat_Id) {
        return amenitiesRepository.findAllAmenitiesByFlatId(flat_Id);
    }


}
