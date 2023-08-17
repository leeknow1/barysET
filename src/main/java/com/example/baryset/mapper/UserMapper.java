package com.example.baryset.mapper;

import com.example.baryset.dto.ShopDTO;
import com.example.baryset.dto.UserDTO;
import com.example.baryset.entity.Region;
import com.example.baryset.entity.User;
import com.example.baryset.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;
    private final RegionMapper regionMapper;

    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setRegionBriefDTO(regionMapper.toBriefDto(user.getRegion()));
        dto.setShops(getUserShops(user.getRegion()));
        return dto;
    }

    public List<UserDTO> toDto(List<User> users) {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toDto(user));
        }
        return dtos;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getId() != null)
            user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        return user;
    }

    private List<ShopDTO> getUserShops(Region region) {
        List<ShopDTO> dtos = new ArrayList<>();
        dtos.add(shopMapper.toDto(shopRepository.findByRegionId(region.getId())));
        if (region.getRegionsIn() != null && !region.getRegionsIn().isEmpty()) {
            for (Region regionsIn : region.getRegionsIn()) {
                dtos.add(shopMapper.toDto(shopRepository.findByRegionId(regionsIn.getId())));
            }
        }
        return dtos;
    }
}
