package com.mhl.mall.config.properties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("redis.key")
@Data
public class CustomRedisProperties {
    private String prefixAuthCode;
    @ApiModelProperty("验证码超期时间")
    private Integer expireAuthCode;
}
