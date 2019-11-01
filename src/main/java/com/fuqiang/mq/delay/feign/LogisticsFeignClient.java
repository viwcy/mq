package com.fuqiang.mq.delay.feign;

import com.fuqiang.mq.delay.model.Logistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>Title: LogisticsFeignClient</p>
 * <p>Description: LogisticsFeignClient</p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 *
 * @author Fuqiang
 * @version 0.0.0.1
 * <pre>Histroy:
 *       2019/11/1 0001 9:20 Create by Fuqiang
 * </pre>
 */
@FeignClient("logistics-application")
public interface LogisticsFeignClient {

    @PostMapping("/logistics/insert")
    void insert(@RequestBody Logistics logistics);
}
