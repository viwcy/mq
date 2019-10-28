package com.fuqiang.mq.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: RabbitMQFanoutConfig</p>
 * <p>Description: RabbitMQFanoutConfig</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy: fanout，即订阅模式，一个生产对应多个消费，消息发送到exchange，queue和exchange进行绑定
 *       2019/10/23 0023 17:11 Create by Fuqiang
 * </pre>
 */
@Configuration
public class RabbitMQFanoutConfig {

    public static final String EXCHANGE_NAME = "fanout_exchange";
    public static final String FANOUT_QUEUE_A = "fanout_queue_A";
    public static final String FANOUT_QUEUE_B = "fanout_queue_B";
    public static final String FANOUT_QUEUE_C = "fanout_queue_C";

    @Bean
    public Queue AMessage() {
        return new Queue(FANOUT_QUEUE_A);
    }

    @Bean
    public Queue BMessage() {
        return new Queue(FANOUT_QUEUE_B);
    }

    @Bean
    public Queue CMessage() {
        return new Queue(FANOUT_QUEUE_C);
    }

    // 生成exchange的bean对象
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    // exchange和A队列绑定
    @Bean
    public Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    // exchange和B队列绑定
    @Bean
    public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    // exchange和C队列绑定
    @Bean
    public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
