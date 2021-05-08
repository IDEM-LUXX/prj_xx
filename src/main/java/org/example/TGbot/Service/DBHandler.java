package org.example.TGbot.Service;

import org.example.TGbot.Service.DB.Users2;
import org.example.TGbot.Service.DB.Users2Repository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.inject.Inject;

@Component
public class DBHandler {

    @Inject
    private final Users2Repository userRepository;

    public DBHandler (Users2Repository repo){
        this.userRepository =repo;
    }

    public SendMessage handle(Update update){
        SendMessage sendMSG = new SendMessage();

        sendMSG.setChatId(update.getMessage().getChatId().toString());
        Users2 user = new Users2(update.getMessage().getText(), update.getMessage().getChatId());
        this.userRepository.saveAndFlush(user);
        sendMSG.setText("user registered succesfully!");
        return sendMSG;
    }

    public Long getRecord (Long chatid) {
        Users2 user = this.userRepository.findByChatid(chatid);
        System.out.println(user.toString());
        Long record = user.getRecord();
        return record;
    }

    public void save (Long chatid, Long record){
        Users2 user = this.userRepository.findByChatid(chatid);
        user.setRecord(record);
        this.userRepository.saveAndFlush(user);
    }

}
