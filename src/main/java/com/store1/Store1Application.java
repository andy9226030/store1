package com.store1;

import jakarta.servlet.MultipartConfigElement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
@Configuration
@MapperScan("com.store1.mapper")
@SpringBootApplication
public class Store1Application {

    public static void main(String[] args) {
        SpringApplication.run(Store1Application.class, args);
    }

    @Bean
    public MultipartConfigElement getmultipartConfigElement() {
        //創建工廠模式
        MultipartConfigFactory multipartConfigElement = new MultipartConfigFactory();
        //回傳並創建 create創建很多的配置
        return multipartConfigElement.createMultipartConfig();
    }

}
