package com.ccsu.shuziyingxin.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-06 13:33
 */
@Configuration
public class Config {
    @Bean
    public ExecutorService getThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        return pool;
    }
}
