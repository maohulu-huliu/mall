package com.mhl.mall.service;


import com.mhl.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author hul
 * @date on 2021/9/27 1:02
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     * @param brand 信息
     * @return 影响行数
     */
    int createBrand(PmsBrand brand);

    /**
     * 跟新品牌信息
     * @param id 品牌id
     * @param brand 品牌更新信息
     * @return 影响行数
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 删除品牌信息
     * @param id 品牌id
     * @return 影响行数
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌列表
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return list brand
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取品牌详情
     * @param id 品牌id
     * @return 品牌信息
     */
    PmsBrand getBrand(Long id);
}
