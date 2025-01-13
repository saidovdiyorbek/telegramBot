package telegram.telegarm_intern.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramBotConfig {
    @Value("${telegram.bot.webhook-path}")
    String webhookPath;
    @Value("${telegram.bot.username}")
    String userName;
    @Value("${telegram.bot.token}")
    String botToken;


    public String getWebhookPath() {
        return webhookPath;
    }

    public String getUserName() {
        return userName;
    }

    public String getBotToken() {
        return botToken;
    }
}
