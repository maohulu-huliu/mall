package com.mhl.mall.dto;

import lombok.Data;

/**
 * 生成订单时传入的参数
 *
 * @author hul
 * @date on 2021/11/15 15:53
 */
@Data
public class OrderParam {
    /**
     * 收货地址id
     */
    private Long memberReceiveAddressId;
    /**
     * 优惠券id
     */
    private Long couponId;
    /**
     * 使用的积分数
     */
    private Integer useIntegration;
    /**
     * 支付方式
     */
    private Integer payType;
}