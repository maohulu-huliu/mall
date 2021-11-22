package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.dto.OrderParam;
import com.mhl.mall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理Controller
 *
 * @author huliou
 * @date 2021/11/15 22:12
 */
@RestController
@Api(tags = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {

    private final OmsPortalOrderService portalOrderService;

    public OmsPortalOrderController(OmsPortalOrderService portalOrderService) {
        this.portalOrderService = portalOrderService;
    }

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping(value = "/generateOrder")
    public CommonResult<Object> generateOrder(@RequestBody OrderParam orderParam) {
        portalOrderService.generateOrder(orderParam);
        return CommonResult.success();
    }
}