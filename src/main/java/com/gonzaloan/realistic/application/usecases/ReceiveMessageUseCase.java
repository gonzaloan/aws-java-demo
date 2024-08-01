package com.gonzaloan.realistic.application.usecases;

import com.gonzaloan.realistic.domain.services.QueueService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiveMessageUseCase {

    private final QueueService queueService;
    public ReceiveMessageUseCase(QueueService queueService) {
        this.queueService = queueService;
    }

    public List<String> execute() {
        return queueService.receiveMessages();
    }
}
