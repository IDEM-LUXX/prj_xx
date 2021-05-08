package org.example.TGbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
@EnableJpaRepositories
public class App {

    @Autowired
    static Bot bot;

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {





        try {
            TelegramBotsApi tgBotapi = new TelegramBotsApi(DefaultBotSession.class);
            tgBotapi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println("shit!");
        }

        SpringApplication.run(App.class, args);
    }




}




