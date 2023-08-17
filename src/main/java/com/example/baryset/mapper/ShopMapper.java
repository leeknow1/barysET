package com.example.baryset.mapper;

import com.example.baryset.dto.ShopDTO;
import com.example.baryset.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopMapper {

    private final RegionMapper regionMapper;

    public ShopDTO toDto(Shop shop) {
        ShopDTO dto = new ShopDTO();
        dto.setId(shop.getId());
        dto.setName(shop.getName());
        dto.setRegion(regionMapper.toBriefDto(shop.getRegion()));
        return dto;
    }

    public List<ShopDTO> toDto(List<Shop> shops) {
        List<ShopDTO> dtos = new ArrayList<>();
        for (Shop shop : shops) {
            dtos.add(toDto(shop));
        }
        return dtos;
    }

    public Shop toEntity(ShopDTO dto) {
        Shop shop = new Shop();
        if (dto.getId() != null)
            shop.setId(dto.getId());
        shop.setName(dto.getName());
        return shop;
    }
}
