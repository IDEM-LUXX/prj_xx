package org.example.TGbot;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.TGbot.Game.Game;
import org.example.TGbot.Handlers.UpdateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;
import java.util.List;

import static org.example.TGbot.STATE.MENU;

@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {

    public STATE state = MENU;

    @Autowired
    public Game game;

    public Long highscore = 0L;

    @Autowired
    private UpdateHandler UpdateHandler;


    public Bot(){

    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        List<PartialBotApiMethod<? extends Serializable>> toExecute = UpdateHandler.handle(update, this);

            toExecute.forEach(response -> {
                if (response instanceof SendMessage) {
                    try{
                        execute((SendMessage) response);
                    } catch (TelegramApiException e){
                        e.printStackTrace();
                    }

                }
            });



    }



    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }
    public void setState(STATE state) {
        this.state = state;
    }

}