package telegram.telegarm_intern.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import telegram.telegarm_intern.service.TelegramFacade;

@Configuration
public class AppConfig {
    private final TelegramBotConfig botConfig;

    public AppConfig(TelegramBotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance(){
        return SetWebhook.builder().url(botConfig.getWebhookPath()).build();
    }

    @Bean
    public MyTelegramBot springWebhookBot(SetWebhook setWebhook, TelegramFacade telegramFacade){
        MyTelegramBot bot = new MyTelegramBot(telegramFacade, setWebhook);
        bot.setBotToken(botConfig.getBotToken());
        bot.setBotUsername(botConfig.getUserName());
        bot.setBotPath(botConfig.getWebhookPath());
        return bot;
    }


}
