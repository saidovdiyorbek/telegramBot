package telegram.telegarm_intern.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import telegram.telegarm_intern.service.TelegramFacade;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyTelegramBot extends SpringWebhookBot {


    String botPath;
    String botUsername;
    String botToken;

    private TelegramFacade telegramFacade;

    public MyTelegramBot(TelegramFacade telegramFacade, DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
        this.telegramFacade = telegramFacade;
    }
    public MyTelegramBot(TelegramFacade telegramFacade, SetWebhook setWebhook) {
        super(setWebhook);
        this.telegramFacade = telegramFacade;
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return telegramFacade.handleUpdate(update);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public TelegramFacade getTelegramFacade() {
        return telegramFacade;
    }

    public void setBotPath(String botPath) {
        this.botPath = botPath;
    }

    public void setTelegramFacade(TelegramFacade telegramFacade) {
        this.telegramFacade = telegramFacade;
    }
}
