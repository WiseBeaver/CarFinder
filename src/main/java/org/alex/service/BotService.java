package org.alex.service;

import org.alex.bot.CarFinderBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotService {

    public  final CarFinderBot carFinderBot = new CarFinderBot();

    public void initBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(carFinderBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
