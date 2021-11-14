package com.mhl.mall.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author huliou
 * @date 2021/11/12 13:41
 */
@Data
@ConfigurationProperties("es")
@Component
public class EsProperties {
    private String userName;
    private String password;
    private String address;
    private Integer port;
}
