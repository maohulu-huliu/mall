package com.mhl.mall.common.exception;

import lombok.Getter;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;


@Getter
public class ApiException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5648781561904624095L;

    /**
     * 响应的状态码
     */
    protected int httpStatus;
    /**
     * 友好错误描述
     */
    protected String message;
    /**
     * 错误的唯一标识（如异常类名称、错误宏/常量定义）
     */
    protected String reason;
    /**
     * 错误恢复建议。
     */
    protected String recoveryOptions;

    /**
     * 调试信息。 比如： 上下文信息， 局部变量信息
     */
    protected Map<String, Object> diagnoseInfo;

    public ApiException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ApiException(int httpStatus, String message, Throwable classReason) {
        super(message, classReason);
        this.httpStatus = httpStatus;
        this.message = message;
        this.reason = classReason != null ? classReason.getClass().getSimpleName() : null;
    }

    public ApiException withReason(String reason) {
        this.reason = reason;
        return this;
    }

    public ApiException withRecoveryOptions(String recoveryOptions) {
        this.recoveryOptions = recoveryOptions;
        return this;
    }

    public ApiException withDiagnoseInfo(Map<String, Object> diagnoseInfo) {
        this.diagnoseInfo = diagnoseInfo;
        return this;
    }

    public ApiException appendDiagnoseInfo(String key, Object value) {
        if (diagnoseInfo == null) {
            diagnoseInfo = new HashMap<>();
        }
        diagnoseInfo.put(key, value);
        return this;
    }

    /**
     * @return {@link #message}(友好错误描述) 成员变量值
     */
    public String getMessageValue() {
        return this.message;
    }
}