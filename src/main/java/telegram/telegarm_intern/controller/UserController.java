package telegram.telegarm_intern.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import telegram.telegarm_intern.dto.user.UserCreateDTO;
import telegram.telegarm_intern.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody UserCreateDTO user) {
        return ResponseEntity.ok(service.create(user));
    }

    @GetMapping("")
    public ResponseEntity<List<UserCreateDTO.UserResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserCreateDTO.UserResponse> update(@PathVariable Long userId, @RequestBody UserCreateDTO updateUser) {
        return ResponseEntity.ok(service.update(userId, updateUser));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable Long userId) {
        return ResponseEntity.ok(service.delete(userId));
    }
}
