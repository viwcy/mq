package com.fuqiang.mq.direct.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: ExchangeConfig</p>
 * <p>Description: ExchangeConfig</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Administrator
 * @version 0.0.0.1
 * <pre>Histroy: 点对点模式
 *       2019/10/22 0022 14:53 Create by Administrator
 * </pre>
 */
@Configuration
public class RabbitMQDirectConfig {

    // 点对点
    public static final String QUEUE_NAME="direct_queue";
    
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME,true);
    }
}
