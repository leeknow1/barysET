package com.example.baryset.controller;

import com.example.baryset.dto.ShopDTO;
import com.example.baryset.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAllShops() {
        List<ShopDTO> results = shopService.getAllShops();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getOneShop(Long id) {
        ShopDTO result = shopService.getOneShop(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createShop(ShopDTO dto) {
        ShopDTO result = shopService.createShop(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping()
    public ResponseEntity<ShopDTO> updateShop(ShopDTO dto) {
        ShopDTO result = shopService.updateShop(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
