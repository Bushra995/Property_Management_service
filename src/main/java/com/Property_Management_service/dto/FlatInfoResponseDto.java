package com.Property_Management_service.dto;

import com.Property_Management_service.model.FlatInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlatInfoResponseDto {
    private List<FlatInfo> flatInfos;
    private boolean moreRecords;
}

