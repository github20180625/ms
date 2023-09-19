package com.sheng.queue.rocket.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "${mq.rocket.topic.user}",
        consumerGroup = "my-group1",
        messageModel = MessageModel.CLUSTERING
)
public class RocketMqConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.printf("received: %s; \n", message);
    }
}
