package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.nosql.mongodb.document.MemberReadHistory;
import com.mhl.mall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员商品浏览记录管理Controller
 *
 * @author hul
 * @date on 2021/11/14 23:19
 */
@RestController
@Api(tags = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<Object> create(@RequestBody MemberReadHistory memberReadHistory) {
        memberReadHistoryService.create(memberReadHistory);
        return CommonResult.success();
    }

    @ApiOperation("删除浏览记录")
    @PostMapping(value = "/delete")
    public CommonResult<Object> delete(@RequestParam("ids") List<String> ids) {
        memberReadHistoryService.delete(ids);
        return CommonResult.success();
    }

    @ApiOperation("展示浏览记录")
    @GetMapping(value = "/list")
    public CommonResult<List<MemberReadHistory>> list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }
}