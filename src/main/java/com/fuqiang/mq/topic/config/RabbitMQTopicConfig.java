package com.fuqiang.mq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: RabbitMQTopicConfig</p>
 * <p>Description: RabbitMQTopicConfig</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 9:31 Create by Fuqiang
 * </pre>
 */
@Configuration
public class RabbitMQTopicConfig {

    public final static String TOPIC_QUEUE_NEWS = "topic_news";
    public final static String TOPIC_QUEUE_WEATHER = "topic_weather";
    public final static String TOPIC_EXCHANGE = "topic_exchange";

    @Bean
    public Queue queueNews() {
        return new Queue(RabbitMQTopicConfig.TOPIC_QUEUE_NEWS);
    }

    @Bean
    public Queue queueWeather() {
        return new Queue(RabbitMQTopicConfig.TOPIC_QUEUE_WEATHER);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * queue绑定exchange，并且指定路由规范routing-key
     * topic.news路由都会绑定queueNews，执行queueNews队列监听的方法
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueNews, TopicExchange exchange) {
        return BindingBuilder.bind(queueNews).to(exchange).with("topic.news");
    }

    /**
     * queue绑定exchange，并且指定路由规范routing-key
     * topic.#（如topic.a,topic.a.b,topic.b等等）路由都会绑定queueWeather，执行queueWeather队列监听的方法
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueWeather, TopicExchange exchange) {
        return BindingBuilder.bind(queueWeather).to(exchange).with("topic.#");
    }

}
