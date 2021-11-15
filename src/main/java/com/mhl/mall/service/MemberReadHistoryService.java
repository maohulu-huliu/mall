package com.mhl.mall.service;

import com.mhl.mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理Service
 *
 * @author hul
 * @date on 2021/11/14 23:15
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    void create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    void delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}