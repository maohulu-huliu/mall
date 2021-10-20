package com.mhl.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author hul
 * @date on 2021/9/27 0:01
 */
@Configuration
@MapperScan("com.mhl.mall.mbg.mapper")
public class MyBatisConfig {
}
