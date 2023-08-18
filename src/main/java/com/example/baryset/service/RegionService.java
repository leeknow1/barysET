package com.example.baryset.service;

import com.example.baryset.dto.RegionBriefDTO;
import com.example.baryset.dto.RegionDTO;
import com.example.baryset.entity.Region;
import com.example.baryset.mapper.RegionMapper;
import com.example.baryset.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public List<RegionBriefDTO> getAllRegions() {
        List<Region> regions = regionRepository.findAll(Sort.by("id"));
        return regionMapper.toBriefDto(regions);
    }

    public RegionBriefDTO getOneRegion(Long id) {
        Region result = regionRepository.findById(id).orElseThrow();
        return regionMapper.toBriefDto(result);
    }

    public RegionDTO createRegion(RegionDTO regionDTO) {
        Region result = regionMapper.toEntity(regionDTO);
        result = regionRepository.save(result);
        return regionMapper.toDto(result);
    }

    public RegionDTO updateRegion(RegionDTO regionDTO) {
        Region result = regionMapper.toEntity(regionDTO);
        result = regionRepository.save(result);
        return regionMapper.toDto(result);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}
