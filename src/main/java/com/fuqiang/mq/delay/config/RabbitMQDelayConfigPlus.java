package com.fuqiang.mq.delay.config;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
  * 生产者 --> 交换机(指定路由，设置时间)  --> 队列(无消费)  --> 变成死信(指定DLX交换机和路由)  --> DLX交换机(路由) -->队列 --> 消费者
  */
@Configuration
public class RabbitMQDelayConfigPlus {

    /**
     * 死信队列，死信交换机，死信路由
     */
    public static final String EXCHANGE = "EXCHANGE";
    public static final String DEAD_QUEUE = "DEAD_QUEUE";
    public static final String DEAD_ROUTING_KEY = "DEAD_KEY";

    /**
     * 转发队列，DLX交换机，转发路由
     */
    public static final String DLX_EXCHANGE = "DEAD_EXCHANGE";
    public static final String REDIRECT_QUEUE = "REDIRECT_QUEUE";
    public static final String REDIRECT_ROUTING_KEY = "REDIRECT_KEY";

    /**
     * 第一次发送消息的交换机
     *
     * @return the exchange
     */
    @Bean
    public Exchange deadExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE).durable(true).build();
    }

    /**
     * 死信交换机，死信之后所转发的交换机，即DLX交换机
     *
     * @return the exchange
     */
    @Bean
    public Exchange redirectExchange() {
        return ExchangeBuilder.directExchange(DLX_EXCHANGE).durable(true).build();
    }

    /**
     * 声明一个死信队列.
     * x-dead-letter-exchange   对应  死信之后的转发交换机
     * x-dead-letter-routing-key  对应 死信之后的转发路由
     *
     * @return the queue
     */
    @Bean
    public Queue deadQueue() {
        Map<String, Object> args = new HashMap<>(2);
        // 声明消息变成死信后,交给指定的交换机和路由键
        args.put("x-dead-letter-exchange", DLX_EXCHANGE);
        args.put("x-dead-letter-routing-key", REDIRECT_ROUTING_KEY);
        // 交代哪个queue被设置成了死信queue，并且携带设置参数
        return QueueBuilder.durable(DEAD_QUEUE).withArguments(args).build();
    }

    /**
     * 正常队列，真正的消费者队列
     *
     * @return the queue
     */
    @Bean
    public Queue redirectQueue() {
        return QueueBuilder.durable(REDIRECT_QUEUE).build();
    }

    /**
     * 第一次发送消息的队列，然后绑定DEAD_QUEUE
     *
     * @return the binding
     */
    @Bean
    public Binding deadBinding() {
        return new Binding(DEAD_QUEUE, Binding.DestinationType.QUEUE, EXCHANGE, DEAD_ROUTING_KEY, null);

    }

    /**
     * 死信转发之后的真正消费者队列
     *
     * @return the binding
     */
    @Bean
    public Binding redirectBinding() {
        return new Binding(REDIRECT_QUEUE, Binding.DestinationType.QUEUE, DLX_EXCHANGE, REDIRECT_ROUTING_KEY, null);
    }
}
