package com.shcode.spring.boot.websocket.scheduler;

import com.shcode.spring.boot.websocket.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Configuration
@EnableScheduling
public class Scheduler {
    private final MessageService messageService;

    Scheduler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Scheduled(fixedRateString = "6000", initialDelayString = "0")
    public void schedulingTask() {
        log.info("Send messages due to schedule");
        messageService.sendMessages("Message from server side to ");
    }
}
