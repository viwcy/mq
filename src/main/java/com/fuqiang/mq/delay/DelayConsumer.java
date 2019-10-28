package com.fuqiang.mq.delay;

import com.alibaba.fastjson.JSON;
import com.fuqiang.mq.delay.config.RabbitMQDelayConfig;
import com.fuqiang.mq.delay.model.Orders;
import com.fuqiang.mq.delay.service.OrdersService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * <p>Title: LazyConsumer</p>
 * <p>Description: LazyConsumer</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 14:25 Create by Fuqiang
 * </pre>
 */
@Component
@RabbitListener(queues = RabbitMQDelayConfig.DELAY_QUEUE)
public class DelayConsumer {

    @RabbitHandler
    public void recive(Orders order) {
        // 订单未支付
        if (order.getStatus() == 0) {
            System.out.println("订单"+order.getId()+"已过期，取消该订单" + JSON.toJSONString(order));
        }else {
            System.out.println("订单"+order.getId()+"支付成功，即将通知物流配送");
        }
    }

}
