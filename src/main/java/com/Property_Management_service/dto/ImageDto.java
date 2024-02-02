package com.Property_Management_service.dto;

import com.Property_Management_service.model.FlatInfo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {
    private Long imageId;


    private FlatInfo flatInfo;
    private String imageAddress;
}
