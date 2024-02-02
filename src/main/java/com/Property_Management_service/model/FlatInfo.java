package com.Property_Management_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "Flat_Info")
    public class FlatInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        @OneToMany(mappedBy = "flatInfo", cascade = CascadeType.ALL)
        private List<Amenities> amenities;

        @OneToMany(mappedBy = "flatInfo", cascade = CascadeType.ALL)
        private List<Images> images;
    }

