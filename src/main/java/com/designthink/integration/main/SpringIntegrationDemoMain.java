package com.designthink.integration.main;

import ch.qos.logback.classic.util.LoggerNameUtil;
import com.designthink.integration.gateway.MessagingGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoMain implements ApplicationRunner {

    private static Logger LOG= LoggerFactory.getLogger(SpringIntegrationDemoMain.class);

    @Autowired
    private MessagingGateway messagingGateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        List<Future<Message<String>>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder.withPayload("Hello-World for Input channel : ")
                    .setHeader("messageNo",i).setPriority(i).build();
            System.out.println("sending Messgae : " + i);
            futures.add(this.messagingGateway.print(message));
        }
    }
}
