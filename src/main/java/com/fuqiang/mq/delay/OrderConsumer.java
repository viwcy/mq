package com.fuqiang.mq.delay;

import com.fuqiang.mq.delay.config.RabbitMQDelayConfigPlus;
import com.fuqiang.mq.delay.feign.LogisticsFeignClient;
import com.fuqiang.mq.delay.mapper.OrdersMapper;
import com.fuqiang.mq.delay.model.Logistics;
import com.fuqiang.mq.delay.model.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <p>Title: OrderConsumer</p>
 * <p>Description: OrderConsumer</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/31 0031 11:00 Create by Fuqiang
 * </pre>
 */
@Component
@Slf4j
public class OrderConsumer {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private LogisticsFeignClient logisticsFeignClient;

    // 监听死信之后的转发队列
    @RabbitListener(queues = RabbitMQDelayConfigPlus.REDIRECT_QUEUE)
    public void handler(Orders order) {
        // 订单id
        String id = order.getId();
        Orders orders = ordersMapper.findById(id);
        log.info("本次订单详情->{}",orders);
        // 未支付
        if (orders.getStatus() == 0) {
            // 取消订单
            ordersMapper.updateOrder(id);
        }else {
            log.info("支付成功，通知物流");
            logisticsFeignClient.insert(new Logistics(UUID.randomUUID().toString(),id,"wangmazi","15268987381"));
            log.info("物流单存储成功");
        }
    }

}
