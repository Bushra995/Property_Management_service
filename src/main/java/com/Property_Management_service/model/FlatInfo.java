package com.Property_Management_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "Flat_Info")
    public class FlatInfo {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;


    @Column(name = "type")
    private String type;

    @Column(name = "Location")
    private String location;

    @Column(name = "Flat_title")
    private String flatTitle;

    @Column(name = "bhk_type")
    private Integer bhkType;

    @Column(name = "g_map_location")
    private String gMapLocation;

    @Column(name = "area")
    private Double area;

    @Column(name = "manual_address")
    private String manualAddress;

    @Column(name = "pin_code")
    private Integer pinCode;

    @Column(name = "is_furnished")
    private String isFurnished;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_constructed")
    private Boolean isConstructed;

    @Column(name = "parking")
    private Integer parking;

    @Column(name = "avaiable_indicator")
    private Integer avaiableIndicator;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "has_balcony")
    private Boolean hasBalcony;

    @Column(name = "description")
    private String description;

    @Column(name = "under_construction")
    private Boolean underConstruction;

    @Column(name = "prop_age")
    private Integer propAge;

    @Column(name = "no_of_bathroom")
    private Integer noOfBathroom;

    @Column(name = "prop_floor")
    private Integer propFloor;

    @Column(name = "prop_type")
    private String propType;

        @OneToMany(mappedBy = "flatInfo", cascade = CascadeType.ALL)
        private List<Amenities> amenities;

        @OneToMany(mappedBy = "flatInfo", cascade = CascadeType.ALL)
        private Set<Images> images = new HashSet<>();

    }

