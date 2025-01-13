package telegram.telegarm_intern.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telegram.telegarm_intern.config.MyTelegramBot;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private MyTelegramBot telegramBot;


}
