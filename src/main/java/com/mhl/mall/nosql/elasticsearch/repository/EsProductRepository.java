package com.mhl.mall.nosql.elasticsearch.repository;

import com.mhl.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 *
 * @author huliou
 * @date 2021/11/12 15:29
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询
     *
     * @param name     商品名称
     * @param subTitle 商品标题
     * @param keywords 商品关键字
     * @param page     分页信息
     * @return Page<EsProduct>
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}