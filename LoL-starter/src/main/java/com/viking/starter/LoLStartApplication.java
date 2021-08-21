package com.viking.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author jiangwei
 * @date 2021/08/21
 **/
@SpringBootApplication(scanBasePackages = "com.viking")
@MapperScan("com.viking.dao")
public class LoLStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoLStartApplication.class, args);
    }
}
