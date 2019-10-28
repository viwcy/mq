package com.fuqiang.mq.topic.api;

import com.fuqiang.mq.topic.TopicProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: RabbitMQTopicApi</p>
 * <p>Description: RabbitMQTopicApi</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 9:44 Create by Fuqiang
 * </pre>
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQTopicApi {

    @Autowired
    private TopicProducter topicProducter;

    @PostMapping("/topic")
    public String product(@RequestParam String message) {
        return topicProducter.send(message);
    }
}
