package com.Property_Management_service.service;

import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import com.Property_Management_service.repository.AmenitiesRepository;
import com.Property_Management_service.repository.FlatInfoRepository;
import com.Property_Management_service.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
        FlatInfo flatInfo = new FlatInfo();
        BeanUtils.copyProperties(flatInfoDto, flatInfo);
        return flatInfoRepository.save(flatInfo);
    }

    @Override
    public FlatInfo getFlatInfoById(Long id) {
        return flatInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FlatInfo", "id", id));
    }

    @Override
    public List<FlatInfo> getFlatInfoLimitFifty(FlatInfoDto flatInfoDto) {
        return flatInfoRepository.findAll().subList(0, Math.min(50, flatInfoRepository.findAll().size()));
    }

    @Override
    public FlatInfo updateFlatInfo(FlatInfoDto flatInfoDto) {
        FlatInfo existingFlatInfo = getFlatInfoById(flatInfoDto.getId());
        BeanUtils.copyProperties(flatInfoDto, existingFlatInfo, "id");
        return flatInfoRepository.save(existingFlatInfo);
    }

    @Override
    public ResponseEntity<String> deleteFlatInfo(Long id) {
        FlatInfo flatInfo = getFlatInfoById(id);
        flatInfoRepository.delete(flatInfo);
        return ResponseEntity.ok("FlatInfo with id " + id + " deleted successfully");
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

    @Override
    public List<FlatInfo> getFlatsByAmenitiesName(String amenitiesName) {
        return flatInfoRepository.findByAmenitiesName(amenitiesName);
    }
}
