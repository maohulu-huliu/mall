package com.mhl.mall.service;

import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * @author hul
 * @date on 2021/11/15 15:47
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}