package com.fuqiang.mq.delay.mapper;

import com.fuqiang.mq.delay.model.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>Title: OrdersMapper</p>
 * <p>Description: OrdersMapper</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/25 0025 16:19 Create by Fuqiang
 * </pre>
 */
@Mapper
public interface OrdersMapper {

    Orders findAll();

    void insertOrder(Orders order);

    void updateOrder(String id);

    Orders findById(String id);
}
