package org.example.TGbot.Game;

import org.example.TGbot.Bot;
import org.example.TGbot.Handlers.CallbackHandler;
import org.example.TGbot.Handlers.MessageHandler;
import org.example.TGbot.Service.DB.Users2;
import org.example.TGbot.Service.DBHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

@Component
public class Game {



    public HashSet<Integer> asked = new HashSet<Integer>();
    public int i = 0;
    public Long result = 0L;
    public int number = 10;
    public Question[] questions = Question.BuildQuestions(number);
    public int[] index = Randomizer.randomizeQue(number);
    public Users2 user;

    @Autowired
    public DBHandler db;



    public Game(Bot bot) {

        for (int i =0; i<number; i++)
           // System.out.println(this.index[i]);
        System.out.println("");

    }


    public List<PartialBotApiMethod<? extends Serializable>> handle(Update update, Bot bot) {

        SendMessage sendMSG = new SendMessage();


        if (update.hasMessage()) {
            return MessageHandler.handle(update, this.questions, this.index, this.i, bot);
            } else if (update.hasCallbackQuery()) {
                return CallbackHandler.handle(update, this.questions, this.index, this.i, bot, db);
            } else {
            return null;
        }


        }

        public void setQuestion(int i){
        this.i = i;
        }

        public void setI(int i){
        this.i = 0;
        this.questions = Question.BuildQuestions(number);
        this.index = Randomizer.randomizeQue(number);
        }

}
