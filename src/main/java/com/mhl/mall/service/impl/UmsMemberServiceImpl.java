package com.mhl.mall.service.impl;

import com.mhl.mall.common.exception.ApiException;
import com.mhl.mall.config.properties.CustomRedisProperties;
import com.mhl.mall.service.RedisService;
import com.mhl.mall.service.UmsMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hul
 * @date on 2021/11/4 22:50
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    private final RedisService redisService;
    private final CustomRedisProperties customRedisProperties;


    public UmsMemberServiceImpl(CustomRedisProperties customRedisProperties, RedisService redisService) {
        this.customRedisProperties = customRedisProperties;
        this.redisService = redisService;
    }

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(customRedisProperties.getPrefixAuthCode() + telephone, sb.toString());
        boolean success = redisService.expire(customRedisProperties.getPrefixAuthCode() + telephone, customRedisProperties.getExpireAuthCode());
        if (!success) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "生成验证码失败");
        }
        return sb.toString();
    }

    @Override
    public void verifyAuthCode(String telephone, String authCode) {
        String realAuthCode = redisService.get(customRedisProperties.getPrefixAuthCode() + telephone);
        boolean success = authCode.equals(realAuthCode);
        if (!success) {
            throw new ApiException(HttpStatus.BAD_REQUEST.value(), "验证码错误!");
        }
    }
}
