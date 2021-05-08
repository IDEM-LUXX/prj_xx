package org.example.TGbot.Handlers;

import org.example.TGbot.Bot;
import org.example.TGbot.Service.DBHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

import static org.example.TGbot.STATE.DB;


@Component
public class UpdateHandler {


    @Inject
    private final DBHandler db;

    public UpdateHandler (DBHandler db){
        this.db = db;
    }



    public List<PartialBotApiMethod<? extends Serializable>> handle(Update update, Bot bot) throws TelegramApiException {


        SendMessage sendMSG = new SendMessage();
        if (update.hasMessage()){
            sendMSG.setChatId(update.getMessage().getChatId().toString());
        }
        sendMSG.setText("wtf went wrong?");



        if (update.hasMessage()){
            if(update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("hello")) {
                   return MessageHandler.handle(update);
                } else if (bot.state == DB) {
                    return MessageHandler.db(update, db);
                }
            }
        } else if (update.hasCallbackQuery()) {
            if(update.getCallbackQuery().getData().equals("db")){
                bot.setState(DB);
                sendMSG.setText("right your name");
                sendMSG.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                return List.of(sendMSG);
            } else {
                return CallbackHandler.handle(update, bot, db);
            }
        }
            return List.of(sendMSG);


    }


}
