package com.mhl.mall.service;


import com.mhl.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author hul
 * @date on 2021/9/27 1:02
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
