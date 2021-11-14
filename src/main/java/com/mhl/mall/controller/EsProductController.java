package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonPage;
import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.nosql.elasticsearch.document.EsProduct;
import com.mhl.mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huliou
 * @date 2021/11/12 16:07
 */
@RestController
@Api(value = "搜索商品管理")
@RequestMapping(path = "/esProduct")
public class EsProductController {
    private final EsProductService esProductService;

    public EsProductController(EsProductService esProductService) {
        this.esProductService = esProductService;
    }

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping(value = "/importAll")
    public CommonResult<Object> importAllList() {
        esProductService.importAllFromDB();
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id删除商品")
    @GetMapping(value = "/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id批量删除商品")
    @PostMapping(value = "/delete/batch")
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping(value = "/create/{id}")
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        return CommonResult.success(esProduct);
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

}