package com.fuqiang.mq.fanout;

import com.fuqiang.mq.fanout.config.RabbitMQFanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: FanoutConsumerB</p>
 * <p>Description: FanoutConsumerB</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy: 此类监听B队列
 *       2019/10/23 0023 17:34 Create by Fuqiang
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQFanoutConfig.FANOUT_QUEUE_B)
public class FanoutConsumerB {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("B收到消息:" + message);
    }
}
