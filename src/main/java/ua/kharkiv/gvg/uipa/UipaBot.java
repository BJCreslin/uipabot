package ua.kharkiv.gvg.uipa;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class UipaBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            if (message_text.toLowerCase().equals("салам")) {
                message_text = "салам попалам";
            }
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    final static private String BotToken = "456915279:AAGoXpOfvd_uSa8pY-x0-wLBqM8EeW_jTX4";
    final static private String BOTNAME = "BJCallBote";

    public String getBOTNAME() {
        return BOTNAME;
    }
    //    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        // TODO
        return BOTNAME;
    }

    public String getBotToken() {
        return BotToken;
    }
}
