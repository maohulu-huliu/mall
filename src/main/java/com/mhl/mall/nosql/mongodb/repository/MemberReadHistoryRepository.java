package com.mhl.mall.nosql.mongodb.repository;

import com.mhl.mall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史Repository
 *
 * @author hul
 * @date on 2021/11/14 23:14
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     *
     * @param memberId 会员id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}