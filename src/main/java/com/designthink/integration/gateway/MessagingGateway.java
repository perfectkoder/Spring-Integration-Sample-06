package com.designthink.integration.gateway;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

public interface MessagingGateway {

    Future<Message<String>> print(Message<?> message);
}
