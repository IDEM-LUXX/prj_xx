package com.example.ConTroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Message;


@RestController
public class ProdController {


    @Autowired
    Producer Producer;

    /*@PostMapping(value="/api/message")
    public Message sendMessage(@RequestBody Message message){
        Producer.sendMessage(message);
        return message;
    }**/

    @PostMapping(value="/api/empty")
    public void test(@RequestParam(name="id") String id,
                     @RequestParam(name="body") String body,
                     @RequestParam(name="queue") String queue)
    {
        Producer.createMessage(id,body,queue);
    }

}