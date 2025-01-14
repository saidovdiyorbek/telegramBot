package telegram.telegarm_intern.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telegram.telegarm_intern.config.MyTelegramBot;
import telegram.telegarm_intern.dto.UserCreateDTO;
import telegram.telegarm_intern.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;



    public String create(UserCreateDTO user) {
        telegramBot.onWebhookUpdateReceived()
    }
}
