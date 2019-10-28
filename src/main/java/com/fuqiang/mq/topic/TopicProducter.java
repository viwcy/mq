package com.fuqiang.mq.topic;

import com.fuqiang.mq.topic.config.RabbitMQTopicConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title: TopicProducter</p>
 * <p>Description: TopicProducter</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 9:27 Create by Fuqiang
 * </pre>
 */
@Component
public class TopicProducter {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 消息体都经过routing-key然后到指定queue，执行该队列监听的方法
    public String send(String context) {
        // 参数分别是交换机，指定路由，发送消息体
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.TOPIC_EXCHANGE, "topic.news" , context);
        return "消息发送成功：" + context;
    }

}
