package ua.kharkiv.gvg;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ua.kharkiv.gvg.uipa.UipaBot;

public class BotConfig {
    public static void main(String[] args) {
        // Initialize Api Context
        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new UipaBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
