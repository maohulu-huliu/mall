package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理
 *
 * @author hul
 * @date on 2021/11/4 22:48
 */
@Api(tags = {"会员登录注册管理"})
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    public CommonResult<String> getAuthCode(@RequestParam("telephone") @ApiParam(value = "电话号码") String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    public CommonResult<Void> updatePassword(@RequestParam("telephone") @ApiParam(value = "电话号码") String telephone,
                                       @RequestParam("authCode") @Length(min = 6, max = 6) String authCode) {
        memberService.verifyAuthCode(telephone, authCode);
        return CommonResult.success();
    }
}
