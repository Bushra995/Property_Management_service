package com.Property_Management_service.Property_Management_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        private Integer flatTitle;
        private String bhkType;
        private Double gMapLocation;
        private String area;
        private String manualAddress;
        private Integer pinCode;
        private String isFurnished;
        private Double price;
        private Boolean isConstructed;
        private Integer parking;
        private Integer availableIndicator;
        private Integer floor;
        private String hasBalcony;
        private String description;
        private Boolean underConstruction;
        private Integer propAge;
        private Integer noOfBathroom;
        private Integer propFloor;
        private String propType;
    }

