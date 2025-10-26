package telegram.telegarm_intern.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

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
                    sendMessage.setText("Assalomu alaykum bot ga xush kelibsiz!\nSizda parol bormi?");

                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();

                    // Tugmachalar yaratish
                    InlineKeyboardButton btn1 = new InlineKeyboardButton();
                    btn1.setText("Ha");
                    btn1.setCallbackData("ha");

                    InlineKeyboardButton btn2 = new InlineKeyboardButton();
                    btn2.setText("Yo'q");
                    btn2.setCallbackData("yoq");

                    rowInline.add(btn1);
                    rowInline.add(btn2);

                    // Tugmalarni ro‘yxatga qo‘shish
                    rowsInline.add(rowInline);
                    markupInline.setKeyboard(rowsInline);

                    // Tugmachalar panelini qo‘shish
                    sendMessage.setReplyMarkup(markupInline);

                    return sendMessage;
                }
                sendMessage.setText("Nima deysan");
                return sendMessage;
            }
        }
        return null;
    }
}
