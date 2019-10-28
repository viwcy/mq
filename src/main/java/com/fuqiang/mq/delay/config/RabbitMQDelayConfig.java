package com.fuqiang.mq.delay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: RabbitMQLazyConfig</p>
 * <p>Description: RabbitMQLazyConfig</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 14:18 Create by Fuqiang
 * </pre>
 */
@Configuration
public class RabbitMQDelayConfig {

    public static final String DELAY_QUEUE = "delay_queue";
    public static final String DELAY_EXCHANGE = "delay_exchange";
    // 路由规则
    public static final String DELAY_ROUTING_KEY = "delay_keys";

    // 创建一个立即消费队列
    @Bean
    public Queue delayQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(DELAY_QUEUE, true);
    }

    // 设置延时交换机exchange
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE, "x-delayed-message", true, false, args);
    }

    // 交换机绑定队列，指定路由
    @Bean
    public Binding bindingNotify() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(DELAY_ROUTING_KEY).noargs();
    }

}
