package com.example.baryset.controller;

import com.example.baryset.dto.UserDTO;
import com.example.baryset.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> results = userService.getAllUsers();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOneUser(@PathVariable Long id) {
        UserDTO result = userService.getOneUser(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
