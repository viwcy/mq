package com.fuqiang.mq.direct;

import com.fuqiang.mq.direct.config.RabbitMQDirectConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * <p>Title: Producter</p>
 * <p>Description: Producter</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Administrator
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/22 0022 15:01 Create by Administrator
 * </pre>
 */
@Component
public class DirectProducter {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(String message) {
        amqpTemplate.convertAndSend(RabbitMQDirectConfig.QUEUE_NAME, message);
        return "消息发送成功：" + message;
    }
}
