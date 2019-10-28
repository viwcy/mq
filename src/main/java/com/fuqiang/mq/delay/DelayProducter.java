package com.fuqiang.mq.delay;

import com.alibaba.fastjson.JSON;
import com.fuqiang.mq.delay.config.RabbitMQDelayConfig;
import com.fuqiang.mq.delay.model.Orders;
import com.fuqiang.mq.delay.service.OrdersService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title: LazyProducter</p>
 * <p>Description: LazyProducter</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 14:17 Create by Fuqiang
 * </pre>
 */
@Component
public class DelayProducter {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private OrdersService ordersService;

    public String send(Orders order) {
        // 交换机和路由
        amqpTemplate.convertAndSend(RabbitMQDelayConfig.DELAY_EXCHANGE, RabbitMQDelayConfig.DELAY_ROUTING_KEY, order, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(20000);
                return message;
            }
        });
        /*amqpTemplate.convertAndSend(RabbitMQDelayConfig.DELAY_EXCHANGE, RabbitMQDelayConfig.DELAY_ROUTING_KEY, object, message -> {
            message.getMessageProperties().setHeader("x-delay",5000);
            return message;
        });*/
        ordersService.insertOrder(order);
        return "订单创建成功：" + JSON.toJSONString(order);
    }
}
