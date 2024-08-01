package com.gonzaloan.realistic.application.usecases;


import com.gonzaloan.realistic.domain.services.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUseCase {

    private final NotificationService notificationService;

    public SendEmailUseCase(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void execute(String message) {
        notificationService.sendMessage(message);
    }
}
