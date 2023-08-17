package com.example.baryset.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private RegionBriefDTO regionBriefDTO;

    private List<ShopDTO> shops;
}
