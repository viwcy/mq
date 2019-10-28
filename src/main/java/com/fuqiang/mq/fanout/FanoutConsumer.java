package com.fuqiang.mq.fanout;

/**
 * <p>Title: Consumer</p>
 * <p>Description: Consumer</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy: 一次可以同时监听多个队列
 *       2019/10/23 0023 17:20 Create by Fuqiang
 * </pre>
 */
/*@Component
@RabbitListener(queues = {RabbitMQFanoutConfig.FANOUT_QUEUE_A,
        RabbitMQFanoutConfig.FANOUT_QUEUE_B, RabbitMQFanoutConfig.FANOUT_QUEUE_C})
public class FanoutConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("收到消息:" + message);
    }
}*/
