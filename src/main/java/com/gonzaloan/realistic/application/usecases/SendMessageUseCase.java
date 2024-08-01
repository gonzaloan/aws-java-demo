package com.gonzaloan.realistic.application.usecases;

import com.gonzaloan.realistic.domain.services.QueueService;
import org.springframework.stereotype.Component;

@Component
public class SendMessageUseCase {

    private final QueueService queueService;
    public SendMessageUseCase(QueueService queueService) {
        this.queueService = queueService;
    }

    public void execute(String message) {
        queueService.sendMessage(message);
    }
}
