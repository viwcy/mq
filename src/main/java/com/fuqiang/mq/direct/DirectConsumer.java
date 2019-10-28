package com.fuqiang.mq.direct;

import com.fuqiang.mq.direct.config.RabbitMQDirectConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: Consumer</p>
 * <p>Description: Consumer</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Administrator
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/22 0022 14:49 Create by Administrator
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQDirectConfig.QUEUE_NAME)
public class DirectConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("收到消息:" + message);
    }
}
