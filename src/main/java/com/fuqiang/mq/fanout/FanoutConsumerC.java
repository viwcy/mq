package com.fuqiang.mq.fanout;

import com.fuqiang.mq.fanout.config.RabbitMQFanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: FanoutConsumerC</p>
 * <p>Description: FanoutConsumerC</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy: 此类监听C队列
 *       2019/10/23 0023 17:35 Create by Fuqiang
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQFanoutConfig.FANOUT_QUEUE_C)
public class FanoutConsumerC {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("C收到消息:" + message);
    }
}