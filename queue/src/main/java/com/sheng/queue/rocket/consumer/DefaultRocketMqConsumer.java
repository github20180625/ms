package com.sheng.queue.rocket.consumer;

import org.apache.logging.log4j.message.Message;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MQConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DefaultRocketMqConsumer {

    private String groupId;

    private String defaultTopic;

    private String userTopic;

    private String nameServer;

    public DefaultRocketMqConsumer(@Value("${mq.rocket.topic.default}") String defaultTopic,
                                   @Value("${mq.rocket.topic.user}") String userTopic,
                                   @Value("${rocketmq.consumer.group}") String groupId,
                                   @Value("${rocketmq.name-server}") String nameServer) {
        this.defaultTopic = defaultTopic;
        this.userTopic = userTopic;
        this.groupId = groupId;
        this.nameServer = nameServer;
        initMqConsumer();
    }

    private void initMqConsumer() {
        DefaultMQPushConsumer mqConsumer = new DefaultMQPushConsumer("my-group1");
        mqConsumer.setNamesrvAddr(nameServer);
        mqConsumer.setMessageModel(MessageModel.CLUSTERING);
        try {
            mqConsumer.subscribe(defaultTopic, "*");
            // 程序第一次启动从消息队列头获取数据
//            mqConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            //负载均衡模式消费
            // consumer.setMessageModel(MessageModel.BROADCASTING);
            //可以修改每次消费消息的数量，默认设置是每次消费一条
            mqConsumer.setConsumeMessageBatchMaxSize(1);
            //在此监听中消费信息，并返回消费的状态信息
            mqConsumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
                // 会把不同的消息分别放置到不同的队列中
                for (MessageExt msg : msgs) {
                    System.out.println("接收到了消息：" + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            mqConsumer.start();
        } catch (Exception e) {

        }

    }


}
