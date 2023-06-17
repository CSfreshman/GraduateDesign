package com.graduateDesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("com/graduateDesign/dao")
public class GraduateDesignApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduateDesignApplication.class, args);
    }
}
