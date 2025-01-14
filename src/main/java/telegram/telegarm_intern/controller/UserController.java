package telegram.telegarm_intern.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telegram.telegarm_intern.config.MyTelegramBot;
import telegram.telegarm_intern.dto.UserCreateDTO;
import telegram.telegarm_intern.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody UserCreateDTO user) {
        return ResponseEntity.ok(service.create(user));
    }
}
