package com.mhl.mall.common.api;

/**
 * 封装API的错误码
 *
 * @author hul
 * @date on 2021/9/27 0:31
 */
public interface IErrorCode {
    /**
     * 获取状态码
     *
     * @return code
     */
    long getCode();

    /**
     * 获取信息
     *
     * @return message
     */
    String getMessage();
}
