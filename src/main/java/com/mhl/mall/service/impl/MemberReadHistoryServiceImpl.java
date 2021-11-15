package com.mhl.mall.service.impl;

import cn.hutool.core.date.DateUtil;
import com.mhl.mall.nosql.mongodb.document.MemberReadHistory;
import com.mhl.mall.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.mhl.mall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员浏览记录管理Service实现类
 *
 * @author hul
 * @date on 2021/11/14 23:16
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public void create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setCreateTime(DateUtil.date());
        memberReadHistoryRepository.save(memberReadHistory);
    }

    @Override
    public void delete(List<String> ids) {
        memberReadHistoryRepository.deleteAllById(ids);
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}