package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.config.properties.CustomJwtProperties;
import com.mhl.mall.dto.UmsAdminLoginDTO;
import com.mhl.mall.mbg.model.UmsAdmin;
import com.mhl.mall.mbg.model.UmsPermission;
import com.mhl.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 */
@RestController
@Api(value = "UmsAdminController", tags = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    private final UmsAdminService adminService;
    private final CustomJwtProperties customJwtProperties;

    public UmsAdminController(UmsAdminService adminService, CustomJwtProperties customJwtProperties) {
        this.adminService = adminService;
        this.customJwtProperties = customJwtProperties;
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult<Map<String, String>> login(@RequestBody @Valid UmsAdminLoginDTO umsAdminLoginDTO, BindingResult result) {
        String token = adminService.login(umsAdminLoginDTO.getUsername(), umsAdminLoginDTO.getPassword());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", customJwtProperties.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
