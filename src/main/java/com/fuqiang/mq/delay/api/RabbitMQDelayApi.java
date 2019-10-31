package com.fuqiang.mq.delay.api;

import com.fuqiang.mq.delay.DelayProducter;
import com.fuqiang.mq.delay.model.Orders;
import com.fuqiang.mq.delay.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * <p>Title: RabbitMQLazyApi</p>
 * <p>Description: RabbitMQLazyApi</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/24 0024 14:28 Create by Fuqiang
 * </pre>
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQDelayApi {

    @Autowired
    private DelayProducter lazyProducter;

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/delay")
    public String product(@RequestParam String message) {
        Orders order = new Orders(UUID.randomUUID().toString(), "zhangsan", "电视", new BigDecimal(13000.00), 0,0);
//        Orders order2 = new Orders(UUID.randomUUID().toString(), "lisi", "冰箱", new BigDecimal(4500.00), 0,0);
        return lazyProducter.send(order);
    }

    /**
     * @methodName insert
     * @description TODO @Transactional用为事务注解，单体事务，方法中有一步错误的时候，整体回退
     * @param
     * @return void
     * @author Fu Qiang
     * @date 2019/10/29 0029 18:00
     */
    @PostMapping("/insert")
    @Transactional
    public void insert() {
        Orders order = new Orders(UUID.randomUUID().toString(), "zhangsan", "电视", new BigDecimal(13000.00), 0,0);
        ordersService.insertOrder(order);
        int a = 10 / 0;
    }
}
