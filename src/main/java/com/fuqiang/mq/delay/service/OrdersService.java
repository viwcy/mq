package com.fuqiang.mq.delay.service;

import com.fuqiang.mq.delay.model.Orders;

import java.util.List;

/**
 * <p>Title: OrdersService</p>
 * <p>Description: OrdersService</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/25 0025 16:26 Create by Fuqiang
 * </pre>
 */
public interface OrdersService {

    Orders findAll();

    void updateOrder(String id);

    void insertOrder(Orders order);
}
