package com.fuqiang.mq.topic;

import com.fuqiang.mq.topic.config.RabbitMQTopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: TopicConsumerB</p>
 * <p>Description: TopicConsumerB</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 9:43 Create by Fuqiang
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQTopicConfig.TOPIC_QUEUE_WEATHER)
public class TopicConsumerB {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("routing-key-B收到消息：" + message);
    }

}
