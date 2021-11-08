package com.mhl.mall.service;

/**
 * @author hul
 * @date on 2021/11/4 22:47
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     *
     * @param telephone 电话号码
     */
    String generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     *
     * @param telephone 电话号码
     * @param authCode  验证码
     */
    void verifyAuthCode(String telephone, String authCode);
}
