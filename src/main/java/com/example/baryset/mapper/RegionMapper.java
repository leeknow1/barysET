package com.example.baryset.mapper;

import com.example.baryset.dto.RegionBriefDTO;
import com.example.baryset.dto.RegionDTO;
import com.example.baryset.entity.Region;
import com.example.baryset.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionMapper {

    private final RegionRepository regionRepository;

    public RegionBriefDTO toBriefDto(Region region) {
        RegionBriefDTO dto = new RegionBriefDTO();
        dto.setId(region.getId());
        dto.setName(region.getName());
        return dto;
    }

    private List<RegionBriefDTO> toBriefDto(List<Region> regions) {
        List<RegionBriefDTO> dtos = new ArrayList<>();
        for (Region region : regions) {
            dtos.add(toBriefDto(region));
        }
        return dtos;
    }

    public RegionDTO toDto(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setId(region.getId());
        dto.setName(region.getName());
        dto.setRegionsIn(toBriefDto(region.getRegionsIn()));
        return dto;
    }

    public List<RegionDTO> toDto(List<Region> regions) {
        List<RegionDTO> dtos = new ArrayList<>();
        for (Region region : regions) {
            dtos.add(toDto(region));
        }
        return dtos;
    }

    public Region toEntity(RegionDTO regionDTO) {
        Region region = new Region();
        if (regionDTO.getId() != null)
            region.setId(regionDTO.getId());
        region.setName(regionDTO.getName());
        region.setRegionsIn(getRegionsIn(regionDTO.getRegionsIn()));
        return region;
    }

    private List<Region> getRegionsIn(List<RegionBriefDTO> dtos) {
        List<Region> regions = new ArrayList<>();
        for (RegionBriefDTO dto : dtos) {
            regions.add(regionRepository.findById(dto.getId()).orElseThrow());
        }
        return regions;
    }
}
