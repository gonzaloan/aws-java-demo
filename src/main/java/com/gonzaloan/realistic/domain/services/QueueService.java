package com.gonzaloan.realistic.domain.services;

import java.util.List;

public interface QueueService {
    List<String> receiveMessages();
    void sendMessage(String message);

}
