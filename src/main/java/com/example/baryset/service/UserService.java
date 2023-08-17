package com.example.baryset.service;

import com.example.baryset.dto.UserDTO;
import com.example.baryset.entity.User;
import com.example.baryset.mapper.UserMapper;
import com.example.baryset.repository.RegionRepository;
import com.example.baryset.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RegionRepository regionRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<User> results = userRepository.findAll();
        return userMapper.toDto(results);
    }

    public UserDTO getOneUser(Long id) {
        User result = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(result);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setRegion(regionRepository.findById(userDTO.getRegionBriefDTO().getId()).orElseThrow());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setRegion(regionRepository.findById(userDTO.getRegionBriefDTO().getId()).orElseThrow());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
