package com.fuqiang.mq;

import com.fuqiang.mq.delay.feign.LogisticsFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
// 必须要加此注解，而且要指定client，不然@FeignClient和@Compontent冲突导致fegin注入失败
@EnableFeignClients(clients = LogisticsFeignClient.class)
public class MqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

}
