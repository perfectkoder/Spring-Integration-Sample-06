package com.designthink.integration.service;

import org.springframework.messaging.Message;

public class UppercaseMessageEnricher {

    public void enrichMessage(Message<String> message){
        //System.out.println("The input Message" + message.getPayload().toUpperCase());
        throw new RuntimeException("Runttime error");
    }
}
