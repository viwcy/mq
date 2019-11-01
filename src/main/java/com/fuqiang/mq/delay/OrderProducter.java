package com.fuqiang.mq.delay;

import com.fuqiang.mq.delay.config.RabbitMQDelayConfig;
import com.fuqiang.mq.delay.config.RabbitMQDelayConfigPlus;
import com.fuqiang.mq.delay.mapper.OrdersMapper;
import com.fuqiang.mq.delay.model.Orders;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title: OrderProducter</p>
 * <p>Description: OrderProducter</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/31 0031 10:54 Create by Fuqiang
 * </pre>
 */
@Component
public class OrderProducter {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 发送消息
     */
    public void send(Orders order) {
        // 交换机和路由
        rabbitTemplate.convertAndSend(RabbitMQDelayConfigPlus.EXCHANGE, RabbitMQDelayConfigPlus.DEAD_ROUTING_KEY, order, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration(20000 + "");
                return message;
            }
        });
        System.out.println("创建订单.........");
        ordersMapper.insertOrder(order);
    }

}
