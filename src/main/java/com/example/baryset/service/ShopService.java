package com.example.baryset.service;

import com.example.baryset.dto.ShopDTO;
import com.example.baryset.entity.Shop;
import com.example.baryset.mapper.ShopMapper;
import com.example.baryset.repository.RegionRepository;
import com.example.baryset.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final RegionRepository regionRepository;
    private final ShopMapper shopMapper;

    public List<ShopDTO> getAllShops() {
        List<Shop> results = shopRepository.findAll();
        return shopMapper.toDto(results);
    }

    public ShopDTO getOneShop(Long id) {
        Shop result = shopRepository.findById(id).orElseThrow();
        return shopMapper.toDto(result);
    }

    public ShopDTO createShop(ShopDTO dto) {
        Shop shop = shopMapper.toEntity(dto);
        shop.setRegion(regionRepository.findById(dto.getRegion().getId()).orElseThrow());
        shop = shopRepository.save(shop);
        return shopMapper.toDto(shop);
    }

    public ShopDTO updateShop(ShopDTO dto) {
        Shop shop = shopMapper.toEntity(dto);
        shop.setRegion(regionRepository.findById(dto.getRegion().getId()).orElseThrow());
        shop = shopRepository.save(shop);
        return shopMapper.toDto(shop);
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
