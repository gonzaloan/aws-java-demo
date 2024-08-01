package com.gonzaloan.realistic.infrastructure.adapters.inbound;

import com.gonzaloan.realistic.application.usecases.ReceiveMessageUseCase;
import com.gonzaloan.realistic.application.usecases.SendMessageUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messaging")
public class MessagingController {

    private final ReceiveMessageUseCase receiveMessageUseCase;
    private final SendMessageUseCase sendMessageUseCase;

    public MessagingController(ReceiveMessageUseCase receiveMessageUseCase, SendMessageUseCase sendMessageUseCase) {
        this.receiveMessageUseCase = receiveMessageUseCase;
        this.sendMessageUseCase = sendMessageUseCase;
    }


    @GetMapping("/receive")
    public List<String> receiveMessages(){
        return receiveMessageUseCase.execute();
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@RequestParam String message) {
        sendMessageUseCase.execute(message);
    }



}
