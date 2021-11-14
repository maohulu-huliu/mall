package com.mhl.mall.controller;

import com.mhl.mall.common.api.CommonPage;
import com.mhl.mall.common.api.CommonResult;
import com.mhl.mall.mbg.model.PmsBrand;
import com.mhl.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hul
 * @date on 2021/10/20 15:19
 */
@Api(value = "PmsBrandController", tags = "品牌管理")
@RestController()
@RequestMapping("/brand")
public class PmsBrandController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    private final PmsBrandService demoService;

    public PmsBrandController(PmsBrandService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("list-all")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    @PostMapping("/create")
    public CommonResult<Object> createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = demoService.createBrand(pmsBrand);
        if (count == 1) {
            LOGGER.debug("createBrand success:{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            LOGGER.debug("createBrand failed:{}", pmsBrand);
            return CommonResult.failed("操作失败");
        }
    }

    @PostMapping("/update/{id}")
    public CommonResult<Object> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto) {
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
            return CommonResult.success(pmsBrandDto);
        }
        LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        return CommonResult.failed("操作失败");
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult<Object> deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        }
        LOGGER.debug("deleteBrand failed :id={}", id);
        return CommonResult.failed("操作失败");
    }

    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @GetMapping("/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(demoService.getBrand(id));
    }
}
