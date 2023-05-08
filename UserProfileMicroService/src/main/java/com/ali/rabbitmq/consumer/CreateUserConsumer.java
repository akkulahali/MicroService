package com.ali.rabbitmq.consumer;

import com.ali.rabbitmq.model.SaveAuthModel;
import com.ali.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
    private final UserProfileService userProfileService;
    @RabbitListener(queues = "queue-auth")
    public void createUserFromHandleQueue(SaveAuthModel model){
        System.out.println("Gelen Data...: "+ model.getUsername());
        userProfileService.saveRabbit(model);
    }
}
