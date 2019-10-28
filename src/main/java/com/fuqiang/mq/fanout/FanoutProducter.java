package com.fuqiang.mq.fanout;

import com.fuqiang.mq.fanout.config.RabbitMQFanoutConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title: Producter</p>
 * <p>Description: Producter</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/23 0023 17:16 Create by Fuqiang
 * </pre>
 */
@Component
public class FanoutProducter {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String send(Object message) {
        // 消息发送到exchange
        rabbitTemplate.convertAndSend(RabbitMQFanoutConfig.EXCHANGE_NAME, "", message);
        return "消息发送成功：" + message;
    }
}
