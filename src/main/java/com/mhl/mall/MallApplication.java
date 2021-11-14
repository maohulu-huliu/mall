package com.mhl.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hul
 * @date on 2021/10/19 14:46
 */
@SpringBootApplication(scanBasePackages = "com.mhl.mall")
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
