package com.fuqiang.mq.delay.service.impl;

import com.fuqiang.mq.delay.mapper.OrdersMapper;
import com.fuqiang.mq.delay.model.Orders;
import com.fuqiang.mq.delay.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: OrdersServiceImpl</p>
 * <p>Description: OrdersServiceImpl</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/25 0025 16:27 Create by Fuqiang
 * </pre>
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Orders findAll() {
        return ordersMapper.findAll();
    }

    @Override
    public void updateOrder(String id) {
        ordersMapper.updateOrder(id);
    }

    @Override
    public void insertOrder(Orders order) {
        ordersMapper.insertOrder(order);
    }
}
