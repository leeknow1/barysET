package com.example.baryset.controller;

import com.example.baryset.dto.RegionDTO;
import com.example.baryset.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionDTO>> getAllRegions() {
        List<RegionDTO> regions = regionService.getAllRegions();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> getOneRegion(@PathVariable Long id) {
        RegionDTO result = regionService.getOneRegion(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<RegionDTO> createRegion(@RequestBody RegionDTO regionDTO) {
        RegionDTO result = regionService.createRegion(regionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<RegionDTO> updateRegion(@RequestBody RegionDTO regionDTO) {
        RegionDTO result = regionService.updateRegion(regionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
        return ResponseEntity.noContent().build();
    }
}
