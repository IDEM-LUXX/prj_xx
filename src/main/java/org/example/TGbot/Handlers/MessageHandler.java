package org.example.TGbot.Handlers;

import org.example.TGbot.Bot;
import org.example.TGbot.Game.Question;
import org.example.TGbot.Service.DBHandler;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;
import java.util.List;

import static org.example.TGbot.Service.KeyboardBuilder.InlineKeyBoard;

public class MessageHandler {



    public static List<PartialBotApiMethod<? extends Serializable>> handle (Update upd) {
        SendMessage sendMSG = new SendMessage();
        sendMSG.setChatId(upd.getMessage().getChatId().toString());
        sendMSG.setText(upd.getMessage().getText()+", shall we start?");
        sendMSG.setReplyMarkup(InlineKeyBoard());


        return List.of(sendMSG);
    }

    public static List<PartialBotApiMethod<? extends Serializable>> db (Update upd, DBHandler db) {

        SendMessage sendMSG = db.handle(upd);

        return List.of(sendMSG);
    }

    public static List<PartialBotApiMethod<? extends Serializable>> handle (Update upd, Question[] questions, int[] index, int i, Bot bot) {

        SendMessage sendMSG = new SendMessage();
        sendMSG.setChatId(upd.getMessage().getChatId().toString());
        sendMSG.setText(questions[0].question);

        sendMSG.setReplyMarkup(InlineKeyBoard(questions[index[i]]));

        return List.of(sendMSG);
    }
}
