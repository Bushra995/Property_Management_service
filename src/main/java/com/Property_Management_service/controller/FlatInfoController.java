package com.Property_Management_service.controller;

import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import com.Property_Management_service.service.FlatInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat-info")
public class FlatInfoController {

    private final FlatInfoServiceImpl flatInfoService;

    @Autowired
    public FlatInfoController(FlatInfoServiceImpl flatInfoService) {
        this.flatInfoService = flatInfoService;
    }

    @PostMapping("/add")
    public ResponseEntity<FlatInfo> addFlatInfo(@RequestBody FlatInfoDto flatInfoDto) {
        FlatInfo addedFlatInfo = flatInfoService.addFlatInfo(flatInfoDto);
        if (addedFlatInfo != null) {
            return ResponseEntity.ok(addedFlatInfo);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<FlatInfo> getFlatInfoById(@PathVariable Long id) {
        FlatInfo flatInfo = flatInfoService.getFlatInfoById(id);
        if (flatInfo != null) {
            return ResponseEntity.ok(flatInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/limit-fifty")
    public ResponseEntity<List<FlatInfo>> getFlatInfoLimitFifty() {
        List<FlatInfo> flatInfoList = flatInfoService.getFlatInfoLimitFifty(null);
        return ResponseEntity.ok(flatInfoList);
    }

    @PutMapping("/update")
    public ResponseEntity<FlatInfo> updateFlatInfo(@RequestBody FlatInfoDto flatInfoDto) {
        FlatInfo updatedFlatInfo = flatInfoService.updateFlatInfo(flatInfoDto);
        if (updatedFlatInfo != null) {
            return ResponseEntity.ok(updatedFlatInfo);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("deleteFlat/{id}")
    public ResponseEntity<ErrorResponse> deleteFlatInfo(@PathVariable Long id) {
        return flatInfoService.deleteFlatInfo(id);

    }


    @GetMapping("/{flatId}/images")
    public ResponseEntity<List<Images>> getImagesByFlatId(@PathVariable Long flatId) {
        List<Images> imagesList = flatInfoService.getImagesByFlatId(flatId);
        return ResponseEntity.ok(imagesList);
    }

    @GetMapping("/{flatId}/amenities")
    public ResponseEntity<List<Amenities>> getAmenitiesByFlatId(@PathVariable Long flatId) {
        List<Amenities> amenitiesList = flatInfoService.getAmenitiesByFlatId(flatId);
        return ResponseEntity.ok(amenitiesList);
    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<FlatInfo>> searchAllStringProperties(@PathVariable String searchTerm) {
        List<FlatInfo> searchResults = flatInfoService.searchAllStringProperties(searchTerm);
        return ResponseEntity.ok(searchResults);
    }
}
