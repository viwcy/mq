package com.fuqiang.mq.delay.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Title: Orders</p>
 * <p>Description: Orders</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/25 0025 16:02 Create by Fuqiang
 * </pre>
 */
@Data
public class Orders implements Serializable {

    private static final Long serialVersionUID = 1L;
    private String id;
    private String user;
    private String goods;
    private BigDecimal price;
    private Integer status;
    private Integer cancel;

    public Orders(String id, String user, String goods, BigDecimal price, Integer status, Integer cancel) {
        this.id = id;
        this.user = user;
        this.goods = goods;
        this.price = price;
        this.status = status;
        this.cancel = cancel;
    }
}
