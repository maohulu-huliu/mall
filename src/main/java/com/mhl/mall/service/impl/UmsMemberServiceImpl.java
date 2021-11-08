package com.mhl.mall.service.impl;

import com.mhl.mall.common.exception.ApiException;
import com.mhl.mall.service.RedisService;
import com.mhl.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hul
 * @date on 2021/11/4 22:50
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        boolean success = redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        if (!success) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "生成验证码失败");
        }
        return sb.toString();
    }

    @Override
    public void verifyAuthCode(String telephone, String authCode) {
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean success = authCode.equals(realAuthCode);
        if (!success) {
            throw new ApiException(HttpStatus.BAD_REQUEST.value(), "验证码错误!");
        }
    }
}
