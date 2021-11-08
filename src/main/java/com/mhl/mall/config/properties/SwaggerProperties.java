package com.mhl.mall.config.properties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("swagger")
@Data
public class SwaggerProperties {
    @ApiModelProperty("是否开启swagger，生产环境一般关闭，所以这里定义一个变量")
    private Boolean enable;

    @ApiModelProperty("项目应用名")
    private String applicationName;

    @ApiModelProperty("项目版本信息")
    private String applicationVersion;

    @ApiModelProperty("项目描述信息")
    private String applicationDescription;

    @ApiModelProperty("接口调试地址")
    private String tryHost;
}