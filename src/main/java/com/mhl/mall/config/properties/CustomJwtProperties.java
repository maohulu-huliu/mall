package com.mhl.mall.config.properties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
@Data
public class CustomJwtProperties {
    @ApiModelProperty("JWT存储的请求头")
    private String tokenHeader;
    @ApiModelProperty("JWT加解密使用的密钥")
    private String secret;
    @ApiModelProperty("JWT的超期限时间(60*60*24)")
    private Integer expiration;
    @ApiModelProperty("JWT负载中拿到开头")
    private String tokenHead;
}
