package com.gonzaloan.realistic.infrastructure.adapters.outbound;

import com.gonzaloan.realistic.domain.services.QueueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQSAdapter implements QueueService {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queueUrl}")
    private String queueUrl;

    public SQSAdapter(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Override
    public List<String> receiveMessages() {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5)
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        return messages.stream()
                .map(Message::body)
                .collect(Collectors.toList());
    }

    @Override
    public void sendMessage(String message) {
        sqsClient.sendMessage(builder -> builder.queueUrl(queueUrl).messageBody(message));
    }
}
