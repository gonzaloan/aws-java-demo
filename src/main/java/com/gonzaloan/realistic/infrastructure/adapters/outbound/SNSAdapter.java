package com.gonzaloan.realistic.infrastructure.adapters.outbound;

import com.gonzaloan.realistic.domain.services.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SNSAdapter implements NotificationService {

    private final SnsClient snsClient;

    @Value("${aws.sns.topicArn}")
    private String topicArn;

    public SNSAdapter(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    @Override
    public void sendMessage(String message) {
        snsClient.publish(PublishRequest.builder()
                        .message(message)
                        .topicArn(topicArn)
                .build());
    }
}
