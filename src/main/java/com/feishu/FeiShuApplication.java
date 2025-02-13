package com.feishu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jidonglin
 * @Description: 启动类
 * @date 2025/02/13  17:06
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.feishu.*")
@MapperScan("com.tgbot.mapper")
@EnableFeignClients
public class FeiShuApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeiShuApplication.class, args);
    }
}
