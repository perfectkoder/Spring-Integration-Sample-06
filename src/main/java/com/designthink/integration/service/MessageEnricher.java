package com.designthink.integration.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class MessageEnricher {

    public void enrichMessage(Message<String> message){
        System.out.println("The input Message" + message.getPayload());
    }
}


