package com.Property_Management_service.controller;

import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.dto.FlatInfoResponseDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import com.Property_Management_service.service.FlatInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/flat-info")
public class FlatInfoController {

    private final FlatInfoServiceImpl flatInfoService;

    @Autowired
    public FlatInfoController(FlatInfoServiceImpl flatInfoService) {
        this.flatInfoService = flatInfoService;
    }

//    @PostMapping("/add")
//    public ResponseEntity<FlatInfo> addFlatInfo(@RequestBody FlatInfoDto flatInfoDto) {
//        FlatInfo addedFlatInfo = flatInfoService.addFlatInfo(flatInfoDto);
//        if (addedFlatInfo != null) {
//            return ResponseEntity.ok(addedFlatInfo);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @PostMapping("/add")
    public ResponseEntity<FlatInfo> addFlatInfo(@ModelAttribute @RequestBody FlatInfoDto flatInfoDto,
                                                @RequestParam("images") Set<MultipartFile> imageFiles) {
        FlatInfo addedFlatInfo = flatInfoService.addFlatInfo(flatInfoDto, imageFiles);

        return ResponseEntity.ok(addedFlatInfo);
    }

    //  for  testing
   /* @PostMapping("/add1")
    public ResponseEntity<Images> addFlatInfo(@RequestParam("images") Set<MultipartFile> imageFiles) throws IOException {
        Images addedFlatInfo = flatInfoService.addimg( imageFiles);
        return (ResponseEntity<Images>) imageFiles;
    }*/
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

    @GetMapping("/paged")
    public ResponseEntity<FlatInfoResponseDto> getFlatInfoPaged(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "20") int pageSize) {
        FlatInfoResponseDto flatInfoResponse = flatInfoService.getFlatInfoPaged(page, pageSize);
        return ResponseEntity.ok(flatInfoResponse);
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
    public ResponseEntity<FlatInfoResponseDto> searchAllStringProperties(@PathVariable String searchTerm, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {

        FlatInfoResponseDto flatInfoSearchResponse = flatInfoService.searchFlatInfoPaged(searchTerm, page, pageSize);
        //List<FlatInfo> searchResults = flatInfoService.searchAllStringProperties(searchTerm);
        return ResponseEntity.ok(flatInfoSearchResponse);
    }

    @GetMapping("/getByAmentities/{amentitiesname}")
    public ResponseEntity<FlatInfoResponseDto> getAllFlatByAmentityName(@PathVariable String amentitiesname, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {

        FlatInfoResponseDto flatInfoSearchResponse = flatInfoService.getFlatsByAmenitiesName(amentitiesname, page, pageSize);
        //List<FlatInfo> searchResults = flatInfoService.searchAllStringProperties(searchTerm);
        return ResponseEntity.ok(flatInfoSearchResponse);
    }

}