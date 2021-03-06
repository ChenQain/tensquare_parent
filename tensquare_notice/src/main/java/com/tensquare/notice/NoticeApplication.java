package com.tensquare.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * NoticeApplication
 *
 * @Author : eden 2020-11-18 17:04
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class NoticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }
}
