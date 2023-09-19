package com.sheng.queue.rocket.producer;

import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/rocket")
public class RocketMqProducer {

    private RocketMQTemplate mqTemplate;

    private MQProducer mQProducer;

    private String defaultTopic;

    private String userTopic;

    public RocketMqProducer(RocketMQTemplate mqTemplate,
                            MQProducer mQProducer,
                            @Value("${mq.rocket.topic.default}") String defaultTopic,
                            @Value("${mq.rocket.topic.user}") String userTopic) {
        this.mqTemplate = mqTemplate;
        this.mQProducer = mQProducer;
        this.defaultTopic = defaultTopic;
        this.userTopic = userTopic;
    }

    @GetMapping("/send")
    public String send(@RequestParam("message") String message) {
//        SendResult result = mqTemplate.syncSend(defaultTopic, message);
        Message message1 = new Message();
        message1.setBody(message.getBytes(StandardCharsets.UTF_8));
        message1.setDelayTimeLevel(0);
        message1.setTopic(defaultTopic);
        try {
            SendResult result = mQProducer.send(message1);
            return result.getMsgId();
        } catch (Exception e) {
            //
            return "";
        }
    }

    @GetMapping("/user/send")
    public String sendUser(@RequestParam("message") String message) {
//        SendResult result = mqTemplate.syncSend(defaultTopic, message);
        Message message1 = new Message();
        message1.setBody(message.getBytes(StandardCharsets.UTF_8));
        message1.setDelayTimeLevel(0);
        message1.setTopic(userTopic);
        try {
            SendResult result = mQProducer.send(message1);
            return result.getMsgId();
        } catch (Exception e) {
            //
            return "";
        }
    }

}
