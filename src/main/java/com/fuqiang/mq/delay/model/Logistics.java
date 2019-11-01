package com.fuqiang.mq.delay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: Logistics</p>
 * <p>Description: Logistics</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/10/31 0031 16:24 Create by Fuqiang
 * </pre>
 */
@Data
public class Logistics implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String id;
    private String orderId;
    private String user;
    private String phone;

    public Logistics(String id, String orderId, String user, String phone) {
        this.id = id;
        this.orderId = orderId;
        this.user = user;
        this.phone = phone;
    }
}
