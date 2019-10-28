package com.fuqiang.mq.fanout;

import com.fuqiang.mq.fanout.config.RabbitMQFanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: FanoutConsumerA</p>
 * <p>Description: FanoutConsumerA</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy: 此类监听A队列
 *       2019/10/23 0023 17:33 Create by Fuqiang
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQFanoutConfig.FANOUT_QUEUE_A)
public class FanoutConsumerA {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("A收到消息:" + message);
    }
}
