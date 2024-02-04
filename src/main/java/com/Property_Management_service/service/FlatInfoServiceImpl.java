package com.Property_Management_service.service;

import com.Property_Management_service.dto.AmenitiesDto;
import com.Property_Management_service.dto.FlatInfoDto;
import com.Property_Management_service.dto.FlatInfoResponseDto;
import com.Property_Management_service.exception.ErrorResponse;
import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.FlatInfo;
import com.Property_Management_service.model.Images;
import com.Property_Management_service.repository.AmenitiesRepository;
import com.Property_Management_service.repository.FlatInfoRepository;
import com.Property_Management_service.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

@Service
public class FlatInfoServiceImpl implements FlatInfoService {

    @Autowired
    private FlatInfoRepository flatInfoRepository;

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Autowired
    private ImageRepository imageRepository;

//    @Override
//    public FlatInfo addFlatInfo(FlatInfoDto flatInfoDto) {
//
//                FlatInfo flatInfo = new FlatInfo();
//                BeanUtils.copyProperties(flatInfoDto, flatInfo);
//                return flatInfoRepository.save(flatInfo);
//       }

    //for testing purpose
   /* public Images addimg( Set<MultipartFile> imagefiles) throws IOException {

        Set<Images> imagesSet = uploadimg(imagefiles);
        return null;

    }


    private Set<Images> uploadimg (Set<MultipartFile> imageFiles) throws IOException {
        Set<Images> imageset1 = new HashSet<>();
        for (MultipartFile file :imageFiles){
            Images images = new Images();
            try {
                images.setImageName(file.getOriginalFilename());
                images.setImageData(file.getBytes());
            }
            catch (IOException eq){
                throw new RuntimeException(eq);
            }
            imageset1.add(images);
        }
        List<Images> savedImageList = imageRepository.saveAll(imageset1);
        return  new HashSet<>(savedImageList);
    }*/

    public FlatInfo addFlatInfo(FlatInfoDto flatInfoDto, Set<MultipartFile> imageFiles) {
        FlatInfo flatInfo = new FlatInfo();
        BeanUtils.copyProperties(flatInfoDto, flatInfo);
        flatInfo = flatInfoRepository.save(flatInfo);
       Set<Images> imagesSet = saveImagesForFlatInfo(flatInfo, imageFiles);
       flatInfo.setImages(imagesSet);
        flatInfoRepository.save(flatInfo);

        if (flatInfoDto.getAmenities() != null && !flatInfoDto.getAmenities().isEmpty()) {
            List<Amenities> amenitiesList = saveAmenitiesForFlatInfo(flatInfo,flatInfoDto.getAmenities() );
            flatInfo.setAmenities(amenitiesList);
        }

        flatInfo = flatInfoRepository.save(flatInfo);
        return flatInfo;
    }
    private Set<Images> saveImagesForFlatInfo(FlatInfo flatInfo, Set<MultipartFile> imageFiles) {
        Set<Images> imagesSet = new HashSet<>();

        for (MultipartFile file : imageFiles) {
            Images image = new Images();
            image.setFlatInfo(flatInfo);
            try {
                image.setImageData(file.getBytes());
                image.setImageName(file.getOriginalFilename());
            }  catch (IOException e) {
                throw new RuntimeException(e);
            }
            imagesSet.add(image);
        }
        if (!imagesSet.isEmpty()) {
            List<Images> savedImageList = imageRepository.saveAll(imagesSet);
            return  new HashSet<>(savedImageList);
        } else {
            return Collections.emptySet();
        }
    }

    private List<Amenities> saveAmenitiesForFlatInfo(FlatInfo flatInfo, List<Amenities> amenitiesListt) {
        List<Amenities> amenitiesList = new ArrayList<>();

        for (Amenities amenities : amenitiesListt) {

            amenities.setFlatInfo(flatInfo);
            amenities.setName(amenities.getName());
            amenitiesList.add(amenities);
        }

        if (!amenitiesList.isEmpty()) {
            return amenitiesRepository.saveAll(amenitiesList);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public FlatInfo getFlatInfoById(Long id) {
        Optional<FlatInfo>  flatinfoPresent = flatInfoRepository.findById(id);
        if(flatinfoPresent.isPresent()){
            return flatinfoPresent.get();
        }
        else {
            return null;
        }
    }

    @Override
    public List<FlatInfo> getFlatInfoLimitFifty(FlatInfoDto flatInfoDto) {
        return flatInfoRepository.findAll().subList(0, Math.min(50, flatInfoRepository.findAll().size()));
    }

    @Override
    public FlatInfoResponseDto getFlatInfoPaged(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<FlatInfo> flatInfoPage = flatInfoRepository.findAll(pageable);

        List<FlatInfo> flatInfos = flatInfoPage.getContent();
        boolean moreRecords = flatInfoPage.hasNext();

        return new FlatInfoResponseDto(flatInfos, moreRecords);
    }

    @Override
    public FlatInfo updateFlatInfo(FlatInfoDto flatInfoDto) {
       Optional<FlatInfo> existingFlatInfo = flatInfoRepository.findById(flatInfoDto.getId());
        if(existingFlatInfo.isPresent()){
        BeanUtils.copyProperties(flatInfoDto, existingFlatInfo.get());
        return flatInfoRepository.save(existingFlatInfo.get());
        }
        else {
            return null;
        }
    }

    @Override
    public ResponseEntity<ErrorResponse> deleteFlatInfo(Long id) {

        Optional<FlatInfo> existingFlatInfo = this.flatInfoRepository.findById(id);

        if(existingFlatInfo.isPresent()){

        flatInfoRepository.delete(existingFlatInfo.get());
        ErrorResponse SuccessResponse = new ErrorResponse("FlatInfo with id " + id + "  deleted successfully", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse);
        }
        else {
            ErrorResponse errorResponse = new ErrorResponse("FlatInfo with id " + id + " not found", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }



    @Override
    public List<Images> getImagesByFlatId(Long flat_id) {
        return imageRepository.findAllImagesByFlatId(flat_id);
    }

    @Override
    public List<Amenities> getAmenitiesByFlatId(Long flat_Id) {
        return amenitiesRepository.findAllAmenitiesByFlatId(flat_Id);
    }



    public FlatInfoResponseDto searchFlatInfoPaged(String searchTerm , int page , int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        Page<FlatInfo> flatInfoPage = flatInfoRepository.searchAllStringPropertiesPageble(searchTerm,pageable);

      List<FlatInfo> flatInfos = flatInfoPage.getContent();

      boolean moreRecords = flatInfoPage.hasNext();
      return  new FlatInfoResponseDto(flatInfos , moreRecords);

    }


    public  FlatInfoResponseDto getFlatsByAmenitiesName(String amentitesName , int page , int pageSize){

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<FlatInfo> flatInfoPage = flatInfoRepository.findByAmenitiesName(amentitesName,pageable);
        List<FlatInfo> flatInfos = flatInfoPage.getContent();

        boolean moreRecords = flatInfoPage.hasNext();
        return  new FlatInfoResponseDto(flatInfos , moreRecords);

    }



}
