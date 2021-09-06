package org.alex.bot;

import org.alex.data.Advertisement;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashSet;
import java.util.Set;

public class CarFinderBot extends TelegramLongPollingBot {

    Set<String> chats = new HashSet<>();

    @Override
    public String getBotToken() {
        return "1914227016:AAEUApVt-JPPPrWaOEaKq4s7faeEWnlZDv8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        chats.add(update.getMessage().getChatId().toString());
    }

    public void writeMessage(Advertisement advertisement) {
        System.out.println("Write");
        for (String id : chats) {
            SendMessage message = new SendMessage();
            message.setText(advertisement.getURL());
            message.setChatId(id);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String getBotUsername() {
        return "car finder";
    }
}
