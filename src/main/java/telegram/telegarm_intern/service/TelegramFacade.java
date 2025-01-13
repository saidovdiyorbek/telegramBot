package telegram.telegarm_intern.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramFacade {
    public BotApiMethod<?> handleUpdate(Update update) {
        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            return null;
        }else {
            Message message = update.getMessage();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            if (message.hasText()){
                if (message.getText().equals("/start")){
                    sendMessage.setText("Kel garang");
                    return sendMessage;
                }
                sendMessage.setText("Nima deysan");
                return sendMessage;
            }
        }
        return null;
    }
}
