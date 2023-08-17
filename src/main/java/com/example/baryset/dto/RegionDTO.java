package com.example.baryset.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegionDTO {

    private Long id;

    private String name;

    private List<RegionBriefDTO> regionsIn;
}
