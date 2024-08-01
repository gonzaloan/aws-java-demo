package com.gonzaloan.realistic.infrastructure.adapters.inbound;

import com.gonzaloan.realistic.application.usecases.SendEmailUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mailing")
public class MailingController {

    private final SendEmailUseCase sendMailUseCase;
    public MailingController(SendEmailUseCase sendMailUseCase) {
        this.sendMailUseCase = sendMailUseCase;
    }

    @PostMapping("/send-mail")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMail(@RequestParam String message) {
        sendMailUseCase.execute(message);
    }

}
