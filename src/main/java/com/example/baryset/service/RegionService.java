package com.example.baryset.service;

import com.example.baryset.dto.RegionDTO;
import com.example.baryset.entity.Region;
import com.example.baryset.mapper.RegionMapper;
import com.example.baryset.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public List<RegionDTO> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        return regionMapper.toDto(regions);
    }

    public RegionDTO getOneRegion(@PathVariable Long id) {
        Region result = regionRepository.findById(id).orElseThrow();
        return regionMapper.toDto(result);
    }

    public RegionDTO createRegion(@RequestBody RegionDTO regionDTO) {
        Region result = regionMapper.toEntity(regionDTO);
        result = regionRepository.save(result);
        return regionMapper.toDto(result);
    }

    public RegionDTO updateRegion(@RequestBody RegionDTO regionDTO) {
        Region result = regionMapper.toEntity(regionDTO);
        result = regionRepository.save(result);
        return regionMapper.toDto(result);
    }

    public void deleteRegion(@PathVariable Long id) {
        regionRepository.deleteById(id);
    }
}
