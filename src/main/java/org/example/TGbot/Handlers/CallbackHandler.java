package org.example.TGbot.Handlers;

import org.example.TGbot.Bot;
import org.example.TGbot.Game.Game;
import org.example.TGbot.Game.Question;
import org.example.TGbot.Service.DBHandler;
import org.example.TGbot.Service.KeyboardBuilder;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;
import java.util.List;

import static org.example.TGbot.STATE.GAME;
import static org.example.TGbot.STATE.MENU;

public class CallbackHandler {


    public static List<PartialBotApiMethod<? extends Serializable>> handle (Update upd, Bot bot, DBHandler db){


        SendMessage sendMSG = new SendMessage();
        if (upd.getCallbackQuery().getData().equals("game")) {
            bot.setState(GAME);
           return bot.game.handle(upd, bot);
        } else {
            sendMSG.setChatId(upd.getCallbackQuery().getMessage().getChatId().toString());
            sendMSG.setText("smth went wrong");
            return bot.game.handle(upd, bot);
        }
    }

    public static List<PartialBotApiMethod<? extends Serializable>> db (Update upd, DBHandler db){

        SendMessage sendMSG = new SendMessage();
        sendMSG = db.handle(upd);

        return List.of(sendMSG);
    }


    public static List<PartialBotApiMethod<? extends Serializable>> handle (Update upd, Question[] questions, int[] index, int i, Bot bot, DBHandler db){

        SendMessage sendMSG = new SendMessage();
        sendMSG.setChatId(upd.getCallbackQuery().getMessage().getChatId().toString());



        if (upd.getCallbackQuery().getData().equals("again")){
            bot.highscore = db.getRecord(upd.getCallbackQuery().getMessage().getChatId());
            bot.game.setI(0);
            bot.setState(MENU);
            sendMSG.setText("here we go again, highscore: "+bot.highscore);
            sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard());

        }else if (upd.getCallbackQuery().getData().equals("nothing")){
            bot.game = new Game(bot);
            bot.setState(MENU);
            sendMSG.setText("i advice you to think again.");
            sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard());

        } else {

            if (i == 0 || upd.getCallbackQuery().getData().equals("game")) {
                bot.highscore = db.getRecord(upd.getCallbackQuery().getMessage().getChatId());
                bot.game.setI(0);
                i=0;
                sendMSG.setText(questions[index[i]].question);
                sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard(questions[index[i]]));

            } else if (i != bot.game.number && i != 0) {


                if (upd.getCallbackQuery().getData().equals(questions[index[i - 1]].check_right)) {
                    ++bot.game.result;
                    sendMSG.setText("well done! " + questions[index[i]].question);
                    sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard(questions[index[i]]));


                } else {
                    sendMSG.setText("wrong! " + questions[index[i]].question);
                    sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard(questions[index[i]]));

                }

            } else {

                if (upd.getCallbackQuery().getData().equals(questions[index[i - 1]].check_right)) {
                    ++bot.game.result;
                    sendMSG.setText("well done! your score: " + bot.game.result + ". looks like you've finished! wanna restart?");
                    sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard(GAME));
                    if(bot.game.result>bot.highscore){
                        db.save(upd.getCallbackQuery().getMessage().getChatId(), bot.game.result);
                    }
                } else {
                    sendMSG.setText("wrong! your score: " + bot.game.result + ". looks like you've finished! wanna restart?");
                    sendMSG.setReplyMarkup(KeyboardBuilder.InlineKeyBoard(GAME));
                    if(bot.game.result>bot.highscore){
                        db.save(upd.getCallbackQuery().getMessage().getChatId(), bot.game.result);
                    }

                }

            }
        }

        bot.game.setQuestion(++i);
        return List.of(sendMSG);

    }


}
