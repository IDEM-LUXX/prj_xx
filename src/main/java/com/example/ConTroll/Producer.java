package com.example.ConTroll;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

@Component
@Slf4j
public class Producer {


    JmsTemplate jmsTemplate;
    JMSContext context;

    public Producer(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
        this.context = jmsTemplate.getConnectionFactory().createContext();
    }


    /*@SneakyThrows
    public void sendMessage(Message message){

        try{
            log.info("Attempting Send message to Queue: "+ queue);
            jmsTemplate.convertAndSend(queue, message);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }**/

    @SneakyThrows
    public void createMessage(String id, String body, String queue){

        Message message = this.context.createMessage();
        message.clearProperties();
        message.clearBody();
        message.setStringProperty("id", id);
        message.setStringProperty("body", body);
        message.setStringProperty("queue", queue);
        jmsTemplate.convertAndSend(queue, message);
    }


}
