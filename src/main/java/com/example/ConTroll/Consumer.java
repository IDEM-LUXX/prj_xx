package com.example.ConTroll;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

@Async
@Component
@Slf4j
public class Consumer implements MessageListener {

    @Autowired
    MessagesRepository repo;

    Date date1 = new Date(2021,05,12);
    Date date2 = new Date(2021,05,10);




    @SneakyThrows
    @Override
    @JmsListener(destination = "${jms.queue.destination}")
    public void onMessage(Message message) {
        try{
            log.info("Received Message!");
            log.info("Messages id: "+message.getStringProperty("id"));
            log.info("Messages body: "+message.getStringProperty("body"));
            log.info("Queue: "+message.getStringProperty("queue"));
            log.info("Time: "+message.getJMSTimestamp());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
        Messages message2 = new Messages();
        message2.setMid(Long.valueOf(message.getStringProperty("id")));
        message2.setBody(message.getStringProperty("body"));
        message2.setQueue(message.getStringProperty("queue"));
        message2.setTiming(new Date(Calendar.getInstance().getTime().getTime()));

        repo.saveAndFlush(message2);
        List<Messages> msg = repo.findByTimingBetween(new Date(Calendar.getInstance().getTime().getTime()), date1);
        List<Messages> msg2 = repo.findByMid(3);
        List<Messages> msg3 = repo.findByQueue("DLQ");
        for (Messages ms : msg){
            System.out.println(ms);
        }
        for (Messages ms : msg2){
            System.out.println(ms);
        }
        for (Messages ms : msg3){
            System.out.println(ms);
        }
    }
}