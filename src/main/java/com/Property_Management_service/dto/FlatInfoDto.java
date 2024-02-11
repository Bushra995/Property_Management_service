package com.Property_Management_service.dto;


import com.Property_Management_service.model.Amenities;
import com.Property_Management_service.model.Images;
import lombok.Getter;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlatInfoDto {
        private Long id;

        private String type;
        private String Location;
        private String flatTitle;
        private Integer bhkType;
        private String gMapLocation;
        private Double area;
        private String manualAddress;
        private Integer pinCode;
        private String isFurnished;
        private Double price;
        private Boolean isConstructed;
        private Integer parking;
        private Integer avaiableIndicator;
        private Integer floor;
        private Boolean hasBalcony;
        private String description;
        private Boolean underConstruction;
        private Integer propAge;
        private Integer noOfBathroom;
        private Integer propFloor;
        private String propType;

        private List<Amenities> amenities;
        private Set<Images> images = new HashSet<>();
        private Set<MultipartFile> imagess = new HashSet<>();
}
