package com.fuqiang.mq.direct.api;

import com.fuqiang.mq.direct.DirectProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: RabbitMQApi</p>
 * <p>Description: RabbitMQApi</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Administrator
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/22 0022 15:03 Create by Administrator
 * </pre>
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQDirectApi {

    @Autowired
    private DirectProducter producter;

    @PostMapping("/direct")
    public String product(@RequestParam String message) {
        if (!StringUtils.isEmpty(message)) {
            return producter.send(message);
        }
        return "消息体不能为空";
    }
}
