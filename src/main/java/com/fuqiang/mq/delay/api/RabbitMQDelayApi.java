package com.fuqiang.mq.delay.api;

import com.fuqiang.mq.delay.DelayProducter;
import com.fuqiang.mq.delay.OrderProducter;
import com.fuqiang.mq.delay.feign.LogisticsFeignClient;
import com.fuqiang.mq.delay.model.Logistics;
import com.fuqiang.mq.delay.model.Orders;
import com.fuqiang.mq.delay.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    private OrderProducter orderProducter;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private LogisticsFeignClient logisticsFeignClient;

    /**
     * @methodName product
     * @description TODO   延时队列
     * @param [message]
     * @return java.lang.String
     * @author Fu Qiang
     * @date 2019/10/31 0031 15:48
     */
    @PostMapping("/delay")
    public String product(@RequestParam String message) {
        Orders order = new Orders(UUID.randomUUID().toString(), "zhangsan", "电视", new BigDecimal(13000.00), 0, 0);
        return lazyProducter.send(order);
    }

    /**
     * @param
     * @return string
     * @methodName send
     * @description TODO 订单延时取消，死信队列
     * @author Fu Qiang
     * @date 2019/10/29 0029 18:00
     */
    @PostMapping("/order")
    public String send() {
        // 模拟创建三条订单
        Orders order1 = new Orders(UUID.randomUUID().toString(), "zhangsan", "电视", new BigDecimal(13000.00), 0, 0);
//        Orders order2 = new Orders(UUID.randomUUID().toString(), "lisi", "冰箱", new BigDecimal(4500.00), 0, 0);
//        Orders order3 = new Orders(UUID.randomUUID().toString(), "wangwu", "电脑", new BigDecimal(15000.00), 0, 0);
        ArrayList<Orders> orders = new ArrayList<>();
        orders.add(order1);
//        orders.add(order2);
//        orders.add(order3);
        orders.forEach(order -> {
            orderProducter.send(order);
        });
        return "订单创建成功";
    }

    /**
     * @param
     * @return void
     * @methodName insert
     * @description TODO @Transactional用为事务注解，单体事务，方法中有一步错误的时候，整体回退
     * @author Fu Qiang
     * @date 2019/10/29 0029 18:00
     */
    @PostMapping("/insert")
    @Transactional
    public void insert() {
        Orders order = new Orders(UUID.randomUUID().toString(), "zhangsan", "电视", new BigDecimal(13000.00), 0, 0);
        ordersService.insertOrder(order);
        int a = 10 / 0;
    }

    @PostMapping("/test")
    public void test() {
        Logistics logistics = new Logistics("01", "01", "wangmazi", "15268987381");
        logisticsFeignClient.insert(logistics);
    }
}
